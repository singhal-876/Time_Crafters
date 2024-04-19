package com.abhinav.timecrafters.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.abhinav.timecrafters.R

class HolidaysRecyclerAdapter(val context: Context, private val itemList: ArrayList<String>): RecyclerView.Adapter<HolidaysRecyclerAdapter.HolidaysViewHolder>() {
    class HolidaysViewHolder (view: View) : RecyclerView.ViewHolder(view){
        val textView: TextView =view.findViewById(R.id.txt_recycle_holidays_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolidaysViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycle_holidays_view, parent,false)
        return HolidaysViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: HolidaysViewHolder, position: Int) {
        val text=itemList[position]
        holder.textView.text=text
    }
}