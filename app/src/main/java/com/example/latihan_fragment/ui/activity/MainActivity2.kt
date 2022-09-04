package com.example.latihan_fragment.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.latihan_fragment.R
import com.example.latihan_fragment.databinding.ActivityMain2Binding
import com.example.latihan_fragment.ui.`interface`.OnDataPass
import com.example.latihan_fragment.ui.fragment.FragmentA
import com.example.latihan_fragment.ui.fragment.FragmentB
import com.example.latihan_fragment.ui.fragment.FragmentC

class MainActivity2 : AppCompatActivity(), OnDataPass {

    private var _binding: ActivityMain2Binding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentA = FragmentA()
        val fragmentB = FragmentB()

        val fragmentManager = supportFragmentManager

        // this code is equal to fragmentManager.commit {} (library needed)
        val fragmentTransaction = fragmentManager.beginTransaction()

        binding.btnReplace.setOnClickListener {
            fragmentManager.commit {
                replace<FragmentC>(R.id.container_a)
            }
        }

        binding.btnRemove.setOnClickListener {
            fragmentManager.commit {
                remove(fragmentB)
            }
        }

        binding.btnPassData.setOnClickListener { // bug force closed if clicked twice
            val bundle = Bundle()
            bundle.putString("MainActivity2", "Sent from MainActivity2")
            fragmentB.arguments = bundle
            fragmentTransaction.add(R.id.container_b, fragmentB).commit()
        } // found out how to pass data to existing fragment (this one must be passed and committed simultaneously)
    }

    override fun onDataPass(data: String) {
        binding.tvDataFragmentReceived.text = data
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}