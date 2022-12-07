package com.testapplication.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomclass.data.Data
import com.testapplication.R
import com.testapplication.ui.main.dataClass.testDataItem

class TestAdapter(  var TestList: ArrayList<Data>,
var mContext: Context,
var callback: IndexItemCallback,
) : RecyclerView.Adapter<TestAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_row, parent, false)
        return ViewHolder(view)
    }


    override fun getItemCount(): Int {
       return TestList.size
    }


    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        var titleTV: TextView= itemView.findViewById(R.id.label)
        var card:CardView=itemView.findViewById(R.id.cardmain)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var dataModel=TestList[position]
        holder.titleTV.text=dataModel.id.toString() +". "+dataModel.title

        holder.card.setOnClickListener {
            callback.onSuggestionCLick(dataModel)
        }
    }
    interface IndexItemCallback {
        fun onSuggestionCLick(mProduct: Data)
    }

}