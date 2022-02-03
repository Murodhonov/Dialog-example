package com.example.hw_16

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.hw_16.Utils.Data
import kotlinx.android.synthetic.main.fragment_my_dialog.*
import kotlinx.android.synthetic.main.fragment_my_dialog.view.*

class MyDialogFragment : DialogFragment() {
    private lateinit var root: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        root =  inflater.inflate(R.layout.fragment_my_dialog, container, false)

        root.signUp.setOnClickListener {
            Toast.makeText(context, "Success sign up", Toast.LENGTH_SHORT).show()
            dialog?.hide()
        }

        return root
    }

    override fun onStart() {
        super.onStart()
        root.rootOfView21.startAnimation(AnimationUtils.loadAnimation(context,R.anim.scale))
        Data.isHome = false
    }

}