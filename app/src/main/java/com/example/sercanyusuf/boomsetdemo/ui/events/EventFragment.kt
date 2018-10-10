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
import com.example.sercanyusuf.boomsetdemo.data.repository.EventRepository
import com.example.sercanyusuf.boomsetdemo.ui.attendees.AttendeeFragment
import com.example.sercanyusuf.boomsetdemo.ui.base.BaseFragment
import com.example.sercanyusuf.boomsetdemo.ui.main.MainActivity
import com.example.sercanyusuf.boomsetdemo.ui.main.MainPresenter
import com.example.sercanyusuf.boomsetdemo.ui.main.MainView
import javax.inject.Inject

class EventFragment : BaseFragment(), MainView.View {


    private lateinit var eventRepo: EventRepository
    private var mLayoutManager: LinearLayoutManager? = null
    private var recyclerView: RecyclerView? = null

    @Inject
    lateinit var mMainPresenter: MainPresenter





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mMainPresenter = MainPresenter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        mMainPresenter.listEvents()
        mMainPresenter.setView(this)
        return inflater.inflate(R.layout.fragment_event, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {


        mLayoutManager = LinearLayoutManager(activity?.applicationContext)
        recyclerView = activity!!.findViewById<RecyclerView>(R.id.events_recyclerview1)
        recyclerView?.layoutManager = this.mLayoutManager
        showWaitingDialog()
        super.onActivityCreated(savedInstanceState)
    }


    override fun ListEvents(events: List<EventResult>) {
        dismissWaitingDialog()
        recyclerView!!.adapter = EventAdapter(events, object : EventAdapter.OnItemClickListener {
            override fun onItemClick(item: EventResult) {
                mMainPresenter.getEvent(item.id!!)
                val attendeeFragment = AttendeeFragment()
                val mBundle = Bundle()
                mBundle.putInt("eventId", item.id!!)
                attendeeFragment.arguments = mBundle
                (activity as MainActivity).switchFragment(attendeeFragment)
                Log.d("TAG", "clicked" + item.name + item.timezone.toString())
            }
        })


    }

    override fun ListAttendees(attendees: List<AttendeeResult>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun displayNetworkError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun displayDatabaseError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
