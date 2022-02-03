package com.example.hw_16

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.example.hw_16.Utils.Data
import kotlinx.android.synthetic.main.custom.view.*
import kotlinx.android.synthetic.main.custom_dialog1.view.*
import kotlinx.android.synthetic.main.fragment_task2.view.*

class Task2Fragment : Fragment() {

    private lateinit var root: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        root =  inflater.inflate(R.layout.fragment_task2, container, false)

        root.btnShow1.setOnClickListener {
            val dialog = AlertDialog.Builder(context).create()

            val itemView = LayoutInflater.from(context).inflate(R.layout.custom_dialog1,null,false)

            itemView.btnCancel1.setOnClickListener {
                Toast.makeText(context, "Cancel clicked", Toast.LENGTH_SHORT).show()
                dialog?.hide()
            }
            itemView.btnRetry1.setOnClickListener {
                Toast.makeText(context, "Retry clicked", Toast.LENGTH_SHORT).show()
                dialog?.hide()
            }

            if(root.btn_chkd.isChecked){
                dialog.setCancelable(false)
            }

            dialog.setView(itemView)

            itemView.dialogRoot.startAnimation(AnimationUtils.loadAnimation(context,R.anim.scale))

            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

            dialog.show()
        }

        return root

    }

    override fun onStart() {
        super.onStart()
        Data.isHome = false
    }

}