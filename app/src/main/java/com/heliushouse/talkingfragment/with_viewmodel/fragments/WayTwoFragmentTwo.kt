package com.heliushouse.talkingfragment.with_viewmodel.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.heliushouse.talkingfragment.R
import com.heliushouse.talkingfragment.databinding.FragmentWayTwoTwoBinding
import com.heliushouse.talkingfragment.with_viewmodel.AwesomeViewModel
import com.heliushouse.talkingfragment.with_viewmodel.AwesomeViewModelFactory

class WayTwoFragmentTwo : Fragment() {
    private lateinit var binding: FragmentWayTwoTwoBinding
    private lateinit var viewModel: AwesomeViewModel
    private lateinit var viewModelFactory: AwesomeViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_way_two_two, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModelFactory = AwesomeViewModelFactory()
        viewModel =
            ViewModelProvider(requireActivity(), viewModelFactory).get(AwesomeViewModel::class.java)
    }

    override fun onResume() {
        super.onResume()
        viewModel.message.observe(requireActivity(), Observer {
            binding.tv.text = it
        } )
    }

    companion object {

        @JvmStatic
        fun newInstance(): WayTwoFragmentTwo {
            return WayTwoFragmentTwo()
        }
    }
}