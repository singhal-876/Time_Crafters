package com.abhinav.timecrafters.fragment

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abhinav.timecrafters.R
import com.abhinav.timecrafters.adapter.LeaveRecyclerAdapter
import java.time.LocalDateTime
import java.time.LocalTime

class LeaveFragment : Fragment() {

    private lateinit var recyclerLeave: RecyclerView
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var recyclerAdapter: LeaveRecyclerAdapter
    private var isLeaveSubmissionEnabled = true
    private val carsList= arrayListOf(
""
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_leave, container, false)

        recyclerLeave=view.findViewById(R.id.recyclerviewleave)
        layoutManager= LinearLayoutManager(activity)
        recyclerAdapter= LeaveRecyclerAdapter(activity as Context, carsList)

        recyclerLeave.adapter = recyclerAdapter
        recyclerLeave.layoutManager = layoutManager
        return view
    }
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val leaveButton = view.findViewById<Button>(R.id.leave_button)
        leaveButton.setOnClickListener {
            submitLeave()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun submitLeave() {
        if (isLeaveSubmissionEnabled) {
            val currentTime = LocalDateTime.now()
            val deadline = LocalDateTime.of(
                currentTime.toLocalDate().plusDays(0),
                LocalTime.of(10, 0) // Deadline at 10:00 PM
            )

            if (currentTime.isBefore(deadline)) {
                // Code to submit leave
                showToast("Leave submitted successfully.")
            } else {
                // Disable leave submission after the deadline
                isLeaveSubmissionEnabled = false
                showToast("Leave submission disabled. Deadline exceeded.")
            }
        } else {
            showToast("Leave submission disabled. Deadline exceeded.")
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}