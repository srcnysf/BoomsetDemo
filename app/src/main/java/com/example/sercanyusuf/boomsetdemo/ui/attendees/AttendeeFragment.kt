package com.example.sercanyusuf.boomsetdemo.ui.attendees

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sercanyusuf.boomsetdemo.R
import com.example.sercanyusuf.boomsetdemo.data.model.attendee.AttendeeResult
import com.example.sercanyusuf.boomsetdemo.data.model.event.EventResult
import com.example.sercanyusuf.boomsetdemo.ui.base.BaseFragment
import com.example.sercanyusuf.boomsetdemo.ui.main.MainPresenter
import com.example.sercanyusuf.boomsetdemo.ui.main.MainView
import com.example.sercanyusuf.boomsetdemo.util.EndlessRecyclerOnScrollListener
import kotlinx.android.synthetic.main.fragment_attendee.*
import java.util.*
import javax.inject.Inject


class AttendeeFragment : BaseFragment(), MainView.View {

    @Inject
    lateinit var mMainPresenter: MainPresenter

    private var mLayoutManager: LinearLayoutManager? = null

    private var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        showWaitingDialog()
        mMainPresenter = MainPresenter()
        mMainPresenter.setView(this)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        if (arguments != null) {
            mMainPresenter.listAttendees(arguments!!.getInt("eventId"))
        }
        return inflater.inflate(R.layout.fragment_attendee, container, false)
    }


    var pageNumber : Int = 1
    var mPrev: Int = 0
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        mLayoutManager = LinearLayoutManager(activity?.applicationContext)
        recyclerView = activity!!.findViewById<RecyclerView>(R.id.attendee_recyclerview)
        recyclerView?.layoutManager = this.mLayoutManager

        recyclerView?.addOnScrollListener(object : EndlessRecyclerOnScrollListener() {
            override fun onLoadMore(mPreviewInt: Int) {
                showWaitingDialog()
                mMainPresenter.listAttendees(arguments!!.getInt("eventId"), pageNumber)
                pageNumber++
                mPrev = mPreviewInt
            }
        })
        super.onActivityCreated(savedInstanceState)
    }
    override fun ListAttendees(attendees: List<AttendeeResult>) {
        dismissWaitingDialog()
        if (recyclerView != null) {
            if (recyclerView!!.adapter == null) {
                recyclerView!!.adapter = AttendeeAdapter(attendees, object : AttendeeAdapter.OnItemClickListener {
                    override fun onItemClick(item: AttendeeResult) {
                        Log.d("TAG", "clicked" + item.contact!!.firstName )

                        var timezoneID = TimeZone.getDefault().id
                        Log.d("Time zone", "=" + timezoneID)
                        Snackbar.make(root, "Question: "+item.answers!![1].question, Snackbar.LENGTH_SHORT).show()
                    }
                })
            } else {
                var items = (recyclerView!!.adapter as AttendeeAdapter).getList()
                items += attendees
                recyclerView!!.adapter = AttendeeAdapter(items, object : AttendeeAdapter.OnItemClickListener {
                    override fun onItemClick(item: AttendeeResult) {
                        Log.d("TAG", "clicked" + item.contact!!.firstName )
                        var timezoneID = TimeZone.getDefault().id
                        Log.d("Time zone", "=" + timezoneID)
                        Snackbar.make(root, "Question: "+item.answers!![1].question, Snackbar.LENGTH_SHORT).show()
                    }
                })
            }
        }

    }

    override fun displayNetworkError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun displayDatabaseError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun ListEvents(events: List<EventResult>) {

    }



}
