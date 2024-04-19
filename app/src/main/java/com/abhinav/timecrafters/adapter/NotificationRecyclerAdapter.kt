package com.abhinav.timecrafters.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.abhinav.timecrafters.R

class NotificationRecyclerAdapter(val context: Context, private val itemList: ArrayList<String>): RecyclerView.Adapter<NotificationRecyclerAdapter.NotificationViewHolder>() {
    class NotificationViewHolder (view: View) : RecyclerView.ViewHolder(view){
        val textView: TextView =view.findViewById(R.id.txt_recycle_notification_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycle_notification_view, parent,false)
        return NotificationViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        val text=itemList[position]
        holder.textView.text=text
    }
}