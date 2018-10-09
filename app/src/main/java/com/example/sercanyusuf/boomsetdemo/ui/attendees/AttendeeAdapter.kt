package com.example.sercanyusuf.boomsetdemo.ui.attendees

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.sercanyusuf.boomsetdemo.R
import com.example.sercanyusuf.boomsetdemo.data.model.attendee.AttendeeResult

class AttendeeAdapter(private val items: List<AttendeeResult>, private val listener: OnItemClickListener) : RecyclerView.Adapter<AttendeeAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(item: com.example.sercanyusuf.boomsetdemo.data.model.attendee.AttendeeResult)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.event_list_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items.get(position), listener)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun getList(): List<AttendeeResult> {
        return items
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val name: TextView
        private val image: ImageView? = null
        private val data: TextView
        private val data1: TextView

        init {
            name = itemView.findViewById<View>(R.id.title) as TextView
            data = itemView.findViewById<View>(R.id.subtitle) as TextView
            data1 = itemView.findViewById<View>(R.id.description) as TextView
        }

        fun bind(item: AttendeeResult, listener: OnItemClickListener) {
            //item.setTimezone(19);
            name.text = item.contact!!.firstName
            data.text = item.contact!!.lastName
            data1.text = item.contact!!.phone.toString()
            itemView.setOnClickListener { listener.onItemClick(item) }
        }
    }
}