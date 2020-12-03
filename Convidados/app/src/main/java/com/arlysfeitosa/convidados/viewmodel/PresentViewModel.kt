package com.arlysfeitosa.convidados.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PresentViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Presents Fragment"
    }
    val text: LiveData<String> = _text
}