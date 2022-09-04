package com.example.latihan_fragment.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.latihan_fragment.R
import com.example.latihan_fragment.databinding.ActivityMainBinding
import com.example.latihan_fragment.ui.fragment.*

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val homeFragment = HomeFragment()
        val chatFragment = ChatFragment()
        val moreFragment = MoreFragment()

        setCurrentFragment(homeFragment)

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> setCurrentFragment(homeFragment)
                R.id.chat -> setCurrentFragment(chatFragment)
                R.id.more -> setCurrentFragment(moreFragment)
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_fragment, fragment)
            commit()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}