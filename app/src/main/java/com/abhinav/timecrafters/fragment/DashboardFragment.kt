package com.abhinav.timecrafters.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abhinav.timecrafters.R
import com.abhinav.timecrafters.adapter.DashboardRecyclerAdapter


class DashboardFragment : Fragment() {

    private lateinit var recyclerDashboard: RecyclerView
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var recyclerAdapter: DashboardRecyclerAdapter

    private val carsList= arrayListOf(
        "| Time        | Monday      | Tuesday     | Wednesday   | Thursday    |\n" +
                "|-------------|-------------|-------------|-------------|-------------|\n" +
                "| 8:00 - 9:00 | Math        | Science     | English     | History     |\n" +
                "| 9:00 - 10:00| Science     | Math        | Geography   | Science     |\n" +
                "| 10:00 - 11:00| Break       | Break       | Break       | Break       |\n" +
                "| 11:00 - 12:00| English     | History     | Math        | Science     |\n" +
                "| 12:00 - 1:00 | Lunch       | Lunch       | Lunch       | Lunch       |\n" +
                "| 1:00 - 2:00  | Geography   | English     | Science     | Math        |\n" +
                "| 2:00 - 3:00  | History     | Geography   | History     | English     |"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        recyclerDashboard=view.findViewById(R.id.recyclerviewdashboard)
        layoutManager=LinearLayoutManager(activity)
        recyclerAdapter= DashboardRecyclerAdapter(activity as Context, carsList)

        recyclerDashboard.adapter = recyclerAdapter
        recyclerDashboard.layoutManager = layoutManager
        return view
    }

}