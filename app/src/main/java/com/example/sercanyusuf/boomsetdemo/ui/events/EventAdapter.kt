package com.example.sercanyusuf.boomsetdemo.ui.events

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.sercanyusuf.boomsetdemo.R
import com.example.sercanyusuf.boomsetdemo.data.model.event.EventResult
import java.util.*

class EventAdapter(private val items: List<EventResult>, private val listener: OnItemClickListener) : RecyclerView.Adapter<EventAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(item: com.example.sercanyusuf.boomsetdemo.data.model.event.EventResult)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.event_list_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position], listener)
    }

    override fun getItemCount(): Int {
        return items.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val name: TextView
        private val image: ImageView? = null
        private val data: TextView
        private val data1: TextView
        private val data2: TextView
        var timezoneID = TimeZone.getDefault().id


        init {
            name = itemView.findViewById<View>(R.id.title) as TextView
            data = itemView.findViewById<View>(R.id.subtitle) as TextView
            data1 = itemView.findViewById<View>(R.id.description) as TextView
            data2 = itemView.findViewById<View>(R.id.description2) as TextView
        }

        @SuppressLint("SetTextI18n")
        fun bind(item: EventResult, listener: OnItemClickListener) {

            if( timezoneID == "Europe/Istanbul"){
                item.timezone = 19
            }
            name.text = item.name
            data.text = "Starts at: " +item.startsat
            data1.text = "Ends at "+item.endsat
            data2.text = item.group!!.name
            itemView.setOnClickListener { listener.onItemClick(item) }
        }
    }
}