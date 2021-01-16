package com.heliushouse.talkingfragment.with_viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AwesomeViewModel: ViewModel() {

    var message = MutableLiveData<String>()
}