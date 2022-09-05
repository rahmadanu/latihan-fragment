package com.example.latihan_fragment.ui.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.latihan_fragment.R
import com.example.latihan_fragment.databinding.FragmentBBinding
import com.example.latihan_fragment.databinding.FragmentHomeBinding
import com.example.latihan_fragment.ui.`interface`.OnDataPass
import com.example.latihan_fragment.ui.model.User

class FragmentB : Fragment() {

    private var _binding: FragmentBBinding? = null
    private val binding get() = _binding!!

    private lateinit var dataPasser: OnDataPass

    override fun onAttach(context: Context) {
        super.onAttach(context)
        dataPasser = context as OnDataPass
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnPassData.setOnClickListener {
            passData("Sent from Fragment B")
        }

        val bundle = arguments

        if (bundle != null) {

            //val message = bundle.getString("MainActivity2")
            val userData = bundle.getParcelable<User>("user")!!

            binding.tvDataParcelableReceived.text = getString(R.string.parcelable_text, userData.name, userData.email)
        }
    }

    fun getData(data: String) {
        binding.tvData2Received.text = data
    }

    private fun passData(data: String) {
        dataPasser.onDataPass(data)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}