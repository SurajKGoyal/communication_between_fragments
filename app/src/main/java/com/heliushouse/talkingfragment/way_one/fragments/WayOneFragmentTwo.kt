package com.heliushouse.talkingfragment.way_one.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.heliushouse.talkingfragment.R
import com.heliushouse.talkingfragment.databinding.FragmentWayOneTwoBinding
import com.heliushouse.talkingfragment.util.FragmentDataListener

class WayOneFragmentTwo : Fragment() {

    lateinit var binding: FragmentWayOneTwoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_way_one_two, container, false)
        return binding.root
    }

    companion object {
        const val TAG = "FRAGMENT_ONE_WAY_ONE"

        @JvmStatic
        fun newInstance(): WayOneFragmentTwo {
            return WayOneFragmentTwo()
        }
    }

    fun onDataSend(message: String) {
        binding.tv.text = message
    }
}