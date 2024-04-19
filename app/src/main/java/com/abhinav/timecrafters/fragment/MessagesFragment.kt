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
import com.abhinav.timecrafters.adapter.MessagesRecyclerAdapter

class MessagesFragment : Fragment() {

    private lateinit var recyclerMessages: RecyclerView
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var recyclerAdapter: MessagesRecyclerAdapter
    private val carsList= arrayListOf(
        "\"Congratulations, hackers! \uD83C\uDF89 Today marks the culmination of our incredible journey through the hackathon. Regardless of the outcomes, your dedication, creativity, and collaboration have made this event truly remarkable. Take pride in your accomplishments, celebrate your hard work, and remember the invaluable experiences gained along the way. Let's continue to innovate and inspire. Best wishes on your future endeavors! #HackathonFinale\""
    )
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_messages, container, false)

        recyclerMessages=view.findViewById(R.id.recyclerviewmesssages)
        layoutManager= LinearLayoutManager(activity)
        recyclerAdapter= MessagesRecyclerAdapter(activity as Context, carsList)

        recyclerMessages.adapter = recyclerAdapter
        recyclerMessages.layoutManager = layoutManager
        return view
    }

}