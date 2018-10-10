package com.example.sercanyusuf.boomsetdemo.ui.attendees

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.sercanyusuf.boomsetdemo.R
import com.example.sercanyusuf.boomsetdemo.data.model.attendee.AttendeeResult

class AttendeeAdapter(private val items: List<AttendeeResult>, private val listener: OnItemClickListener) : RecyclerView.Adapter<AttendeeAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(item: com.example.sercanyusuf.boomsetdemo.data.model.attendee.AttendeeResult)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.attendee_list_item, parent, false)
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
        private val lName: TextView
        private val company: TextView
        private val mail: TextView

        init {
            name = itemView.findViewById<View>(R.id.firstname) as TextView
            lName = itemView.findViewById<View>(R.id.lastname) as TextView
            company = itemView.findViewById<View>(R.id.company) as TextView
            mail = itemView.findViewById<View>(R.id.mail) as TextView


        }

        fun bind(item: AttendeeResult, listener: OnItemClickListener) {
            name.text = item.contact!!.firstName
            lName.text = item.contact!!.lastName
            if(item.workInfo!!.company!!.isEmpty()){
                company.text = "Person doesnt work"
            }else {
                company.text = "Company: " + item.workInfo!!.company
            }
            mail.text = item.contact!!.email
            itemView.setOnClickListener { listener.onItemClick(item) }
        }
    }
}