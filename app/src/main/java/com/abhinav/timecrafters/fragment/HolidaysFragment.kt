package com.abhinav.timecrafters.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abhinav.timecrafters.R
import com.abhinav.timecrafters.adapter.HolidaysRecyclerAdapter

class HolidaysFragment : Fragment() {

    private lateinit var recyclerHolidays: RecyclerView
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var recyclerAdapter: HolidaysRecyclerAdapter

    private val carsList= arrayListOf(
        "3rd week of Saturday (20/01/24)\n\n" +
                "Republic Day (26/01/24)\n\n" +
        "1st week of Saturday (03/02/24)\n\n" +
        "Vasant Panchami (14/02/24)\n\n" +
                "3rd week of Saturday (17/02/24)\n\n" +
                "1st week of Saturday (02/03/24)\n\n" +
        "Maha Shivratri (08/03/24)\n\n" +
                "3rd week of Saturday (16/03/24)\n\n" +
        "Holi (25/03/24)"
    )

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_holidays, container, false)

        recyclerHolidays=view.findViewById(R.id.recyclerviewholidays)
        layoutManager= LinearLayoutManager(activity)
        recyclerAdapter= HolidaysRecyclerAdapter(activity as Context, carsList)

        recyclerHolidays.adapter = recyclerAdapter
        recyclerHolidays.layoutManager = layoutManager
        return view
    }
}