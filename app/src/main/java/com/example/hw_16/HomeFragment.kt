package com.example.hw_16

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.hw_16.Utils.Data
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {
    private lateinit var root: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        root = inflater.inflate(R.layout.fragment_home, container, false)

        root.btn1.setOnClickListener {
            findNavController().navigate(R.id.task1Fragment)
        }

        root.btn2.setOnClickListener {
            findNavController().navigate(R.id.task2Fragment)
        }

        root.btn3.setOnClickListener {
            findNavController().navigate(R.id.task3Fragment)
        }

        return root
    }

    override fun onStart() {
        super.onStart()
        Data.isHome = true
    }

}