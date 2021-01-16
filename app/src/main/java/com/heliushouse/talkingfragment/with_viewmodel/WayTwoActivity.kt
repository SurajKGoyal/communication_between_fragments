package com.heliushouse.talkingfragment.with_viewmodel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.heliushouse.talkingfragment.R
import com.heliushouse.talkingfragment.databinding.ActivityWayTwoBinding
import com.heliushouse.talkingfragment.util.HelperMethods
import com.heliushouse.talkingfragment.with_viewmodel.fragments.WayTwoFragmentOne
import com.heliushouse.talkingfragment.with_viewmodel.fragments.WayTwoFragmentTwo

class WayTwoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWayTwoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_way_two)
        binding.lifecycleOwner = this

        HelperMethods.addFragmentNoBackStackToActivity(
            supportFragmentManager,
            WayTwoFragmentOne.newInstance(),
            R.id.container1
        )
        HelperMethods.addFragmentNoBackStackToActivity(
            supportFragmentManager,
            WayTwoFragmentTwo.newInstance(),
            R.id.container2
        )
    }
}