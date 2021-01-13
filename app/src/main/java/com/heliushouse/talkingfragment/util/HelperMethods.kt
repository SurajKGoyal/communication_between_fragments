package com.heliushouse.talkingfragment.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

object HelperMethods {
    fun addFragmentNoBackStackToActivity(
        fragmentManager: FragmentManager,
        fragment: Fragment, frameId: Int
    ) {
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(frameId, fragment).disallowAddToBackStack()
        transaction.commit()
    }
}