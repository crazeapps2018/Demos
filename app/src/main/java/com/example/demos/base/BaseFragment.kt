package com.example.demos.base

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment


abstract class  BaseFragment: Fragment() {

    private var onYesClickListener:OnYesClickListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return provideYourFragmentView(inflater, container, savedInstanceState)
    }



    abstract fun provideYourFragmentView(
        inflater: LayoutInflater?,
        parent: ViewGroup?,
        savedInstanceState: Bundle?
    ): View

    fun showAlert(msg:String,id:Int = 0,reqId:Int=0){
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())

        builder.setTitle("Confirm")
        builder.setMessage("Are you sure to want to do $msg?")

        builder.setPositiveButton("YES", DialogInterface.OnClickListener { dialog, which -> // Do nothing but close the dialog

            onYesClickListener!!.onYesClick(msg,id = id,reqId = reqId)
            dialog.dismiss()

        })

        builder.setNegativeButton("NO", DialogInterface.OnClickListener { dialog, which -> // Do nothing
            dialog.dismiss()
        })

        val alert: AlertDialog = builder.create()
        alert.show()
    }

    fun setOnYesClickListener(listener: OnYesClickListener){

        onYesClickListener = listener

    }

    interface OnYesClickListener{
        fun onYesClick(from:String,id:Int = 0,reqId: Int)
    }

    fun showToast(msg:String){
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    }

}