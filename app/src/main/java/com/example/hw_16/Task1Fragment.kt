package com.example.hw_16

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.ProgressDialog.show
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.hw_16.Utils.Data
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.bottom_dialog.view.*
import kotlinx.android.synthetic.main.custom.view.*
import kotlinx.android.synthetic.main.custom_dialog1.view.*
import kotlinx.android.synthetic.main.fragment_task1.*
import kotlinx.android.synthetic.main.fragment_task1.view.*

class Task1Fragment : Fragment() {

    private lateinit var root: View

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        root = inflater.inflate(R.layout.fragment_task1, container, false)

        root.alert_dialog.setOnClickListener {
            val alert = AlertDialog.Builder(context)
            alert.setTitle("Hello")
            alert.setMessage("This is a message from AlertDialog")

            alert.setPositiveButton("Ok ") { _, _ ->
                Toast.makeText(context, "Ok clicked ", Toast.LENGTH_SHORT).show()
            }

            alert.setNegativeButton("Cancel ") { _, _ ->
                Toast.makeText(context, "Cancel ", Toast.LENGTH_SHORT).show()
            }

            alert.setNeutralButton("About me ") { _, _ ->
                Toast.makeText(context, "@Murodhonov ", Toast.LENGTH_SHORT).show()
            }
            

            alert.show()
        }
        root.custom_dialog.setOnClickListener {
            val dialog = AlertDialog.Builder(context).create()

            val itemView = LayoutInflater.from(context).inflate(R.layout.custom,null,false)

            dialog.setView(itemView)

            itemView.rootView12.startAnimation(AnimationUtils.loadAnimation(context,R.anim.scale))

            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

            dialog.show()
        }

        root.fragment_dialog.setOnClickListener {
            MyDialogFragment().show(parentFragmentManager.beginTransaction(),"fragment")
        }

        root.datapicker_dialog.setOnClickListener {
            val datepicker = DatePickerDialog(root.context)

            datepicker.setOnDateSetListener { view, year, month, dayOfMonth ->
                Toast.makeText(context, "$year//${month+1}//$dayOfMonth", Toast.LENGTH_SHORT).show()
            }

            datepicker.show()
        }

        root.timepicker_dialog.setOnClickListener {
            val timePicker = TimePickerDialog(context, { view, hourOfDay, minute ->

                    Toast.makeText(context, "$hourOfDay:$minute", Toast.LENGTH_SHORT).show()

                }, 24, 60, true,)


            timePicker.show()
        }

        root.bottomsheet_dialog.setOnClickListener {
            val bottomSheetDialog = BottomSheetDialog(root.context)
            val itemView = LayoutInflater.from(context).inflate(R.layout.bottom_dialog,null,false)
            bottomSheetDialog.setContentView(itemView)
            itemView.bottomRoot.startAnimation(AnimationUtils.loadAnimation(context,R.anim.slide_up))
            bottomSheetDialog.show()
        }
        root.snackbar.setOnClickListener {
            Snackbar.make(it,"Hello from world",Snackbar.LENGTH_SHORT).setAction("Click me!") {
                Snackbar.make(it,"Clicked !!",Snackbar.LENGTH_SHORT).show()
            }.show()
        }

        return root
    }

    override fun onStart() {
        super.onStart()
        Data.isHome = false
    }


}