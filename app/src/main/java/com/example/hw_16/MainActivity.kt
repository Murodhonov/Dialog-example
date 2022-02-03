package com.example.hw_16

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AlertDialog
import com.example.hw_16.Utils.Data
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.back_pressed.view.*
import kotlinx.android.synthetic.main.custom.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

    }

    override fun onBackPressed() {
       if (Data.isHome){
           val d = BottomSheetDialog(this)

           val i = LayoutInflater.from(this).inflate(R.layout.back_pressed,null,false)

           d.setContentView(i)

           i.btnYoq.setOnClickListener {
               d.hide()
           }
           i.btnHa.setOnClickListener {
               d.hide()
               super.onBackPressed()
           }

           d.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

           i.backRoot.startAnimation(AnimationUtils.loadAnimation(this,R.anim.scale))

           d.setCancelable(true)

           d.show()
       }else{
           super.onBackPressed()
       }
    }
}