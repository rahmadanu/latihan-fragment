package com.example.latihan_fragment.ui.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.latihan_fragment.databinding.FragmentHomeBinding
import com.example.latihan_fragment.ui.`interface`.OnDataPass
import com.example.latihan_fragment.ui.activity.MainActivity2

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAnotherFragmentOperation.setOnClickListener {
            val intent = Intent(activity, MainActivity2::class.java)
            intent.putExtra("test", "data from home fragment via intent")
            startActivity(intent)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}