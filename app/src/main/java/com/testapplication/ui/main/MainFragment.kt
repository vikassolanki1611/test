package com.testapplication.ui.main

import android.app.Activity
import android.content.ComponentName
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.telephony.PhoneNumberUtils
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.example.roomclass.data.Data
import com.testapplication.R
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment(), TestAdapter.IndexItemCallback {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View { return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        if(viewModel.getalldata().value==null){
            viewModel.getAPIdata()
            getalldataDB()
        }
        else{
            getalldataDB()

        }
        cvWhatsapp.setOnClickListener {

            openWhatsAppChat(requireActivity(),"8010606065")
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)









    }


    fun getalldataDB(){
        viewModel.getalldata().observe(viewLifecycleOwner) {
          val testadapter=TestAdapter(it as ArrayList<Data>, requireActivity().applicationContext,this)
            testRV.adapter=testadapter
            testRV.smoothScrollToPosition(0)
        }
    }

    override fun onSuggestionCLick(mData: Data) {
        val ft: FragmentTransaction = requireFragmentManager().beginTransaction()
        ft.replace(R.id.container, secondFragment.newInstance(mData), "NewFragmentTag")
        ft.addToBackStack("back")
        ft.commit()
    }

    fun openWhatsAppChat(activity: Activity, whatsupNumber: String) {
        var whatsupNumber = whatsupNumber
        if (!TextUtils.isEmpty(whatsupNumber)) {
            whatsupNumber = whatsupNumber.replace("+", "").replace(" ", "")
            val isWhatsappInstalled: Boolean = appInstalledOrNot(activity, "com.whatsapp")
            if (isWhatsappInstalled) {
                val sendIntent = Intent("android.intent.action.MAIN")
                sendIntent.component = ComponentName("com.whatsapp", "com.whatsapp.Conversation")
                sendIntent.putExtra(
                    "jid",
                    PhoneNumberUtils.stripSeparators(whatsupNumber) + "@s.whatsapp.net"
                ) //phone number without "+" prefix
                activity.startActivity(sendIntent)
            } else {
                val uri: Uri = Uri.parse("market://details?id=com.whatsapp")
                val goToMarket = Intent(Intent.ACTION_VIEW, uri)
                Toast.makeText(activity, "WhatsApp not Installed", Toast.LENGTH_SHORT).show()
                activity.startActivity(goToMarket)
            }
        } else {
            Toast.makeText(activity, "WhatsApp number not available.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun appInstalledOrNot(activity: Activity, uri: String): Boolean {
        val pm = activity.packageManager
        var app_installed = false
        app_installed = try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }
        return app_installed
    }

}