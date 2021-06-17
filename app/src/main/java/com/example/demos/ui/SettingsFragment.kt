package com.example.demos.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.demos.R
import kotlinx.android.synthetic.main.activity_main.*

class SettingsFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).toolbar_title.setText("Settings")
        (activity as MainActivity?)!!.supportActionBar!!.setDisplayHomeAsUpEnabled(false)
        (activity as MainActivity?)!!.supportActionBar!!.setDisplayShowHomeEnabled(false)

        val btn = view.findViewById<Button>(R.id.doPaymentBtn)

        btn.setOnClickListener {
            val fragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frameLayout, PaymentFragment())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }


    }


}