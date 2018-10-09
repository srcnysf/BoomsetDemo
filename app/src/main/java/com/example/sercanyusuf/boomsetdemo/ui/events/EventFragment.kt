package com.example.sercanyusuf.boomsetdemo.ui.events

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sercanyusuf.boomsetdemo.R
import com.example.sercanyusuf.boomsetdemo.data.model.attendee.AttendeeResult
import com.example.sercanyusuf.boomsetdemo.data.model.event.EventResult
import com.example.sercanyusuf.boomsetdemo.ui.attendees.AttendeeFragment
import com.example.sercanyusuf.boomsetdemo.ui.base.BaseFragment
import com.example.sercanyusuf.boomsetdemo.ui.main.MainActivity
import com.example.sercanyusuf.boomsetdemo.ui.main.MainPresenter
import com.example.sercanyusuf.boomsetdemo.ui.main.MainView
import java.util.*
import javax.inject.Inject


class EventFragment : BaseFragment(), MainView {

    @Inject
    internal lateinit var mMainPresenter: MainPresenter
    private var mLayoutManager: LinearLayoutManager? = null
    private var eventsAdapter: EventAdapter? = null
    private var recyclerView: RecyclerView? = null
    private var eventId : Int? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mMainPresenter = MainPresenter()
        mMainPresenter.setView(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        mMainPresenter.listEvents()

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_event, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        mLayoutManager = LinearLayoutManager(activity?.applicationContext)
        recyclerView = activity!!.findViewById<RecyclerView>(R.id.events_recyclerview1)
        recyclerView?.layoutManager = this.mLayoutManager




        super.onActivityCreated(savedInstanceState)
    }




    override fun ListEvents(events: List<EventResult>) {

        recyclerView!!.adapter = EventAdapter(events, object : EventAdapter.OnItemClickListener {
            override fun onItemClick(item: EventResult) {
                mMainPresenter.getEvent(item.id!!)
                val attendeeFragment = AttendeeFragment()

                val mBundle = Bundle()
                mBundle.putInt("eventId", item.id!!)
                attendeeFragment.arguments = mBundle
                (activity as MainActivity).switchFragment(attendeeFragment)

                Log.d("TAG", "clicked" + item.name + item.timezone.toString())

                var timezoneID = TimeZone.getDefault().id
                Log.d("Time zone", "=" + timezoneID);
                // Toast.makeText(getContext(), "Item Clicked", Toast.LENGTH_LONG).show()

            }
        })


    }




    override fun displayNetworkError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun displayDatabaseError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun ListAttendees(attendees: List<AttendeeResult>) {

    }


}
