package com.arlysfeitosa.convidados.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GuestFormViewModel : ViewModel() {

    private var mSaveGuest = MutableLiveData<Boolean>()
    val saveGuest:LiveData<Boolean> = mSaveGuest

    fun save(name: String, presence: Boolean) {

    }
}