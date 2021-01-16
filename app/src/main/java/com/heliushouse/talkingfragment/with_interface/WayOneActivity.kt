package com.heliushouse.talkingfragment.with_interface

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.heliushouse.talkingfragment.R
import com.heliushouse.talkingfragment.databinding.ActivityWayOneBinding
import com.heliushouse.talkingfragment.util.HelperMethods
import com.heliushouse.talkingfragment.with_interface.fragments.WayOneFragmentOne
import com.heliushouse.talkingfragment.with_interface.fragments.WayOneFragmentTwo

class WayOneActivity : AppCompatActivity(), FragmentDataListener {
    private lateinit var binding: ActivityWayOneBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_way_one)
        binding.lifecycleOwner = this

        HelperMethods.addFragmentNoBackStackToActivity(
            supportFragmentManager,
            WayOneFragmentOne.newInstance(),
            R.id.container1
        )
        HelperMethods.addFragmentNoBackStackToActivity(
            supportFragmentManager,
            WayOneFragmentTwo.newInstance(),
            R.id.container2
        )
    }

    override fun onDataSend(message: String) {
        val fragment = supportFragmentManager.findFragmentById(R.id.container2) as WayOneFragmentTwo
        fragment.onDataSend(message)

    }
}