package com.example.tasks.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tasks.service.listener.ValidationListener
import com.example.tasks.service.model.PriorityModel
import com.example.tasks.service.repository.PriorityRepository

class TaskFormViewModel(application: Application) : AndroidViewModel(application) {

    private val mPriorityRepository = PriorityRepository(application)

    private val mpriorityList = MutableLiveData<List<PriorityModel>>()
    var priorities: LiveData<List<PriorityModel>> = mpriorityList

    fun listPriorities(){
        mpriorityList.value = mPriorityRepository.list()
    }
}