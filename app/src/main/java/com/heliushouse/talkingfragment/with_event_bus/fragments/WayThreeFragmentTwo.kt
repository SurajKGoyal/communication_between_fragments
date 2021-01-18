package com.heliushouse.talkingfragment.with_event_bus.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.heliushouse.talkingfragment.R
import com.heliushouse.talkingfragment.databinding.FragmentWayThreeTwoBinding
import com.heliushouse.talkingfragment.with_event_bus.MessageEvent
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class WayThreeFragmentTwo : Fragment() {
    private lateinit var binding: FragmentWayThreeTwoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_way_three_two, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }
    override fun onResume() {
        super.onResume()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(event: MessageEvent){
        binding.tv.text = event.message
    }


    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }
    companion object {

        @JvmStatic
        fun newInstance(): WayThreeFragmentTwo {
            return WayThreeFragmentTwo()
        }
    }
}