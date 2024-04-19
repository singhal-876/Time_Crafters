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
import com.abhinav.timecrafters.adapter.NotificationRecyclerAdapter

class NotificationFragment : Fragment() {

    private lateinit var recyclerNotification: RecyclerView
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var recyclerAdapter: NotificationRecyclerAdapter

    private val carsList= arrayListOf(
        "Internal Hackathon: 18th-19th March 2024\n" +
                "Dear Educators,\n" +
                " Greetings!\n" +
                "\n" +
                "We are thrilled to announce that the much-anticipated programme of Tula's Internal Hackathon 2024 has been launched!\n" +
                "\n" +
                "This year, Tula's Internal Hackathon is back with even more enthusiasm, challenges, and opportunities to harness the power of innovation and technology for a smarter and More sustainable India.\n" +
                "\n" +
                "This is a mega event and I request you all to encourage students (From All the Department) to participate in Hackathon-2024.\n" +
                "\n" +
                "Kindly visit https://tulashackathon.My.canva.site/2024 for More information.\n" +
                "\n" +
                "Deadline:\n" +
                "\n" +
                "Registration: I1th March 2024 onwards\n" +
                "\n" +
                "Idea Submission: 12th March 2024 to 15th March 2024 Idea Screening Result (Shortlisting of Ideas): 16th March 2024\n" +
                "\n" +
                "Internal Hackathon: 18th-19th March 2024\n" +
                "\n" +
                "Kindly connect to event Coordinator Ms. Divya Negi, Contact +91 9870642705, Email divyanegi@tulas.edu.in and Mr. Anuj Singh Rajput, Contact +91 9319305170, Email: anuj@tulas.edu.in, to get more information, submit Team Details, Problem Statement and for any issue or concern.\n" +
                "\n" +
                "Thanks and Regards Department of CSE"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_notification, container, false)

        recyclerNotification=view.findViewById(R.id.recyclerviewnotification)
        layoutManager= LinearLayoutManager(activity)
        recyclerAdapter= NotificationRecyclerAdapter(activity as Context, carsList)

        recyclerNotification.adapter = recyclerAdapter
        recyclerNotification.layoutManager = layoutManager
        return view
    }
}