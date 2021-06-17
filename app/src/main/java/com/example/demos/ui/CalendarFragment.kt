package com.example.demos.ui

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.DatePicker
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.demos.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_calendar.*
import java.util.*


class CalendarFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calendar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).toolbar.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.bg))

        (activity as MainActivity).toolbar_title.setText("Calendar")
        (activity as MainActivity).toolbar_title.textSize = 25F
        (activity as MainActivity).toolbar_title.setTextColor(ContextCompat.getColor(requireContext(),R.color.white))

       // val calendarView = view.findViewById<CalendarView>(R.id.calendarView)
        val datePicker = view.findViewById<DatePicker>(R.id.calendarView)
        val textView = view.findViewById<AppCompatTextView>(R.id.textView)


        val calendarMinDate = Calendar.getInstance()
        calendarMinDate.set(Calendar.DATE,Calendar.getInstance().getActualMinimum(Calendar.DATE))
        val mindate  = calendarMinDate.time.time

        val calendarMaxDate = Calendar.getInstance()
        calendarMaxDate.set(Calendar.DAY_OF_MONTH, calendarMaxDate.getActualMaximum(Calendar.DAY_OF_MONTH));
        val maxdate  = calendarMaxDate.time.time

        datePicker.minDate = mindate
        datePicker.maxDate = maxdate

        datePicker.minDate = System.currentTimeMillis() - 1000

        calendarView.setOnDateChangeListener(object : CalendarView.OnDateChangeListener{
            override fun onSelectedDayChange(
                view: CalendarView,
                year: Int,
                month: Int,
                dayOfMonth: Int
            ) {

                val date = dayOfMonth.toString() + "−" + (month + 1) + "−" + year
                textView.text = date
            }

        })



    }

}