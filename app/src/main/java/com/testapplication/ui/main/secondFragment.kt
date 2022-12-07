package com.testapplication.ui.main


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.roomclass.data.Data
import com.testapplication.R
import kotlinx.android.synthetic.main.second_fragment.*

class secondFragment : Fragment() {

    companion object {
        fun newInstance(mData: Data):secondFragment
        { val bundle=Bundle()
            val fragment=secondFragment()
            bundle.putParcelable("data",mData)
            fragment.arguments=bundle
            return fragment
        }
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val args=arguments
        var mData= args!!.getParcelable<Data>("data")
        tvID.text=mData!!.id.toString()
        tvUserId.text=mData!!.userId.toString()
        tvTitle.text=mData!!.title.toString()
        tvBody.text=mData!!.body.toString()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.second_fragment, container, false)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }





}