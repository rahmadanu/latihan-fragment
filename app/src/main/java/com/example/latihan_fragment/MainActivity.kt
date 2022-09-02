package com.example.latihan_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.latihan_fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentB = FragmentB()

        val fragmentManager = supportFragmentManager

        // this code is equal to fragmentManager.commit {} (library needed)
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.container_b, fragmentB)
        fragmentTransaction.commit()

        binding.btnReplace.setOnClickListener {
            fragmentManager.commit {
                replace(R.id.container_a, FragmentC())
            }
        }

        binding.btnRemove.setOnClickListener {
            fragmentManager.commit {
                remove(fragmentB)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}