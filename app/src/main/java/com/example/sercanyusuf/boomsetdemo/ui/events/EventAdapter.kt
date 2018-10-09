package com.example.sercanyusuf.boomsetdemo.ui.events

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.example.sercanyusuf.boomsetdemo.R
import com.example.sercanyusuf.boomsetdemo.data.model.Result

class EventAdapter(private val items: List<Result>, private val listener: OnItemClickListener) : RecyclerView.Adapter<EventAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(item: Result)
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

        init {
            name = itemView.findViewById<View>(R.id.title) as TextView
            data = itemView.findViewById<View>(R.id.subtitle) as TextView
            data1 = itemView.findViewById<View>(R.id.description) as TextView
        }

        fun bind(item: Result, listener: OnItemClickListener) {
            //item.setTimezone(19);
            name.text = item.name
            data.text = item.startsat
            data1.text = item.endsat
            itemView.setOnClickListener { listener.onItemClick(item) }
        }
    }
}