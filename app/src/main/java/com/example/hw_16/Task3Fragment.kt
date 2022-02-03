package com.example.hw_16

import android.app.AlertDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.example.hw_16.Utils.Data
import kotlinx.android.synthetic.main.awesome_dialog.*
import kotlinx.android.synthetic.main.awesome_dialog.view.*
import kotlinx.android.synthetic.main.custom.view.*
import kotlinx.android.synthetic.main.fragment_task3.view.*

class Task3Fragment : Fragment() {

    private lateinit var root: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        root = inflater.inflate(R.layout.fragment_task3, container, false)

        root.btnDialog.setOnClickListener {
            val dial = AlertDialog.Builder(context).create()

            val itemView = LayoutInflater.from(context).inflate(R.layout.awesome_dialog,null,false)

            dial.setView(itemView)

            itemView.btnOkay.setOnClickListener {
                dial.hide()
            }

            if(root.btn_chkd2.isChecked){
                dial.setCancelable(false)
            }

            itemView.rootDialog.startAnimation(AnimationUtils.loadAnimation(context,R.anim.scale))

            dial.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

            dial.show()
        }

        return root
    }

    override fun onStart() {
        super.onStart()
        Data.isHome = false
    }


}