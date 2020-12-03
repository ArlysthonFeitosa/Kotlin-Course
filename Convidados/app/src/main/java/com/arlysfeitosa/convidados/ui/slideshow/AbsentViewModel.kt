package com.arlysfeitosa.convidados.ui.slideshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AbsentViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Absents Fragment"
    }
    val text: LiveData<String> = _text
}