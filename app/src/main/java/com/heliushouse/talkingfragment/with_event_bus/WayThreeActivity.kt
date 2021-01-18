package com.heliushouse.talkingfragment.with_event_bus

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.heliushouse.talkingfragment.R
import com.heliushouse.talkingfragment.databinding.ActivityWayThreeBinding
import com.heliushouse.talkingfragment.util.HelperMethods
import com.heliushouse.talkingfragment.with_event_bus.fragments.WayThreeFragmentOne
import com.heliushouse.talkingfragment.with_event_bus.fragments.WayThreeFragmentTwo

class WayThreeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWayThreeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_way_three)
        binding.lifecycleOwner = this

        HelperMethods.addFragmentNoBackStackToActivity(
            supportFragmentManager,
            WayThreeFragmentOne.newInstance(),
            R.id.container1
        )
        HelperMethods.addFragmentNoBackStackToActivity(
            supportFragmentManager,
            WayThreeFragmentTwo.newInstance(),
            R.id.container2
        )
    }
}