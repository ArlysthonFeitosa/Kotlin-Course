package com.arlysfeitosa.convidados.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arlysfeitosa.convidados.service.constants.GuestConstants
import com.arlysfeitosa.convidados.service.model.GuestModel
import com.arlysfeitosa.convidados.service.repository.GuestRepository

class GuestsViewModel(application: Application) : AndroidViewModel(application) {

    //Instanciando repositório indiretamente
    private val mGuestRepository = GuestRepository(application.applicationContext)

    //Lista com os convidados para ir para a Recycler View
    private val mGuestList = MutableLiveData<List<GuestModel>>()

    //variável para ser observada da fragment
    val guestList: LiveData<List<GuestModel>> = mGuestList

    //Carregar para recycler
    fun load(filter: Int) {
        //filtrar os convidados necessários para preencher a recycler
        if (filter == GuestConstants.FILTER.EMPTY) {
            mGuestList.value = mGuestRepository.getAll()

        } else if (filter == GuestConstants.FILTER.PRESENT) {
            mGuestList.value = mGuestRepository.getPresent()

        } else {
            mGuestList.value = mGuestRepository.getAbsent()
        }
    }

    //função para apagar da lista, que acessa o repositório
    fun delete(id: Int){
        val guest = mGuestRepository.get(id)
        mGuestRepository.delete(guest)
    }
}