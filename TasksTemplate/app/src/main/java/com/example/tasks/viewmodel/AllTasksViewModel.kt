package com.example.tasks.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tasks.service.listener.APIListener
import com.example.tasks.service.model.PriorityModel
import com.example.tasks.service.model.TaskModel
import com.example.tasks.service.repository.TaskRepository
import com.example.tasks.view.MainActivity

class AllTasksViewModel(application: Application) : AndroidViewModel(application) {

    private val mTaskRepository = TaskRepository(application)

    private val mList = MutableLiveData<List<TaskModel>>()
    var tasks: LiveData<List<TaskModel>> = mList

    fun list() {
        mTaskRepository.all(object : APIListener<List<TaskModel>> {
            override fun onSuccess(model: List<TaskModel>) {
                mList.value = model
            }

            override fun onFaliure(str: String) {
                mList.value = arrayListOf()
            }
        })
    }

    fun delete(id:Int){
        mTaskRepository.delete(id, object : APIListener<Boolean>{
            override fun onSuccess(model: Boolean) {
                list()
            }

            override fun onFaliure(str: String) {

            }
        })
    }

    fun complete(id: Int) {
        updateStatus(id, true)
    }

    fun undo(id: Int) {
        updateStatus(id, false)
    }

    private fun updateStatus(id:Int, complete:Boolean){
        mTaskRepository.updateStatus(id, complete, object : APIListener<Boolean>{
            override fun onSuccess(model: Boolean) {
                list()
            }
            override fun onFaliure(str: String) {
            }
        })
    }
}