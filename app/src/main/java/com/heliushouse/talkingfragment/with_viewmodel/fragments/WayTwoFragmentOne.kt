package com.heliushouse.talkingfragment.with_viewmodel.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.heliushouse.talkingfragment.R
import com.heliushouse.talkingfragment.databinding.FragmentWayTwoOneBinding
import com.heliushouse.talkingfragment.with_viewmodel.AwesomeViewModel
import com.heliushouse.talkingfragment.with_viewmodel.AwesomeViewModelFactory

class WayTwoFragmentOne : Fragment() {
    private lateinit var binding: FragmentWayTwoOneBinding
    private lateinit var viewModel: AwesomeViewModel
    private lateinit var viewModelFactory: AwesomeViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_way_two_one, container, false)
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
        binding.submit.setOnClickListener {
            if (binding.editText.text.toString() != "") {
                viewModel.message.value = binding.editText.text.toString()
            } else {
                Toast.makeText(requireActivity(), "Enter a message First!", Toast.LENGTH_SHORT)
                    .show()
            }

        }
    }

    companion object {

        @JvmStatic
        fun newInstance(): WayTwoFragmentOne {
            return WayTwoFragmentOne()
        }
    }
}