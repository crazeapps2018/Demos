package com.example.demos.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.demos.R
import com.example.demos.base.BaseFragment
import kotlinx.android.synthetic.main.activity_main.*

class PaymentFragment : BaseFragment(),BaseFragment.OnYesClickListener {

    override fun provideYourFragmentView(
        inflater: LayoutInflater?,
        parent: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return inflater!!.inflate(R.layout.fragment_payment, parent, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).toolbar_title.setText("Payment")
        (activity as MainActivity?)!!.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        (activity as MainActivity?)!!.supportActionBar!!.setDisplayShowHomeEnabled(true)
        setHasOptionsMenu(true)



        setOnYesClickListener(this)

        val checkBtn = view.findViewById<Button>(R.id.checkoutBtn)
        val cardNumber = ""
        val cardExpMonth = ""
        val cardExpYear = ""
        val cardCVC = ""

        checkBtn.setOnClickListener {

            showAlert("Payment",reqId = 1)

        }


    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                (activity as MainActivity).supportFragmentManager.popBackStack()
                return true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onYesClick(from: String, id: Int,reqId:Int) {

        showToast("Payment Done $reqId")
    }



}