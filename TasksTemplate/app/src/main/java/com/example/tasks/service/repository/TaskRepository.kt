package com.example.tasks.service.repository

import android.content.Context
import com.example.tasks.R
import com.example.tasks.service.constants.TaskConstants
import com.example.tasks.service.listener.APIListener
import com.example.tasks.service.model.HeaderModel
import com.example.tasks.service.model.TaskModel
import com.example.tasks.service.repository.remote.RetrofitClient
import com.example.tasks.service.repository.remote.TaskService
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TaskRepository(val context: Context) {

    private val mRemote = RetrofitClient.createService(TaskService::class.java)

    fun create(task: TaskModel, listener: APIListener<Boolean>) {
        val call: Call<Boolean> =
            mRemote.create(task.priorityId, task.description, task.dueDate, task.complete)

        call.enqueue(object : Callback<Boolean> {
            override fun onFailure(call: Call<Boolean>, t: Throwable) {
                listener.onFaliure(context.getString(R.string.ERROR_UNEXPECTED))
            }

            override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
                //Se a resposta for diferente de 200 (200 - sucesso)
                if (response.code() != TaskConstants.HTTP.SUCCESS) {
                    //Pegando erro em Json e tratando
                    val validation = Gson().fromJson(
                        response.errorBody()!!.string(),
                        String::class.java
                    )
                    listener.onFaliure(validation)
                } else {
                    //it - Modelo retornado da API
                    response.body()?.let { listener.onSuccess(it) }
                }
            }
        })
    }
}