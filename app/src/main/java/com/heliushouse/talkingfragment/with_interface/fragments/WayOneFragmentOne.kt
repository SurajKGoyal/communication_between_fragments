package com.heliushouse.talkingfragment.with_interface.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.heliushouse.talkingfragment.R
import com.heliushouse.talkingfragment.databinding.FragmentWayOneOneBinding
import com.heliushouse.talkingfragment.with_interface.FragmentDataListener


class WayOneFragmentOne : Fragment() {

    private lateinit var binding: FragmentWayOneOneBinding
    lateinit var listener: FragmentDataListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_way_one_one, container, false)
        try {
            listener = activity as FragmentDataListener
        } catch (e: ClassCastException) {
            throw ClassCastException(activity.toString() + " must implement onButtonPressed")
        }
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        binding.submit.setOnClickListener {
            if(binding.editText.text.toString() != ""){
                listener.onDataSend(binding.editText.text.toString())
            }else{
                Toast.makeText(requireActivity(), "Enter a message First!", Toast.LENGTH_SHORT).show()
            }

        }
    }

    companion object {

        @JvmStatic
        fun newInstance(): WayOneFragmentOne {
            return WayOneFragmentOne()
        }

    }
}