package com.heliushouse.talkingfragment.with_event_bus.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.heliushouse.talkingfragment.R
import com.heliushouse.talkingfragment.databinding.FragmentWayThreeOneBinding
import com.heliushouse.talkingfragment.with_event_bus.MessageEvent
import org.greenrobot.eventbus.EventBus


class WayThreeFragmentOne : Fragment() {

    private lateinit var binding: FragmentWayThreeOneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_way_three_one, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        binding.submit.setOnClickListener {
            if(binding.editText.text.toString() != ""){
//                listener.onDataSend(binding.editText.text.toString())
                EventBus.getDefault().post(MessageEvent(binding.editText.text.toString()))
            }else{
                Toast.makeText(requireActivity(), "Enter a message First!", Toast.LENGTH_SHORT).show()
            }

        }
    }

    companion object {

        @JvmStatic
        fun newInstance(): WayThreeFragmentOne {
            return WayThreeFragmentOne()
        }
    }
}