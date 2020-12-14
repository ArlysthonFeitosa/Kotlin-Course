package com.example.tasks.service.repository

import android.content.Context
import com.example.tasks.R
import com.example.tasks.service.HeaderModel
import com.example.tasks.service.constants.TaskConstants
import com.example.tasks.service.listener.APIListener
import com.example.tasks.service.repository.remote.PersonService
import com.example.tasks.service.repository.remote.RetrofitClient
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import kotlin.coroutines.coroutineContext

class PersonRepository(val context:Context) {

    private val mRemote = RetrofitClient.createService(PersonService::class.java)

    fun login(email: String, password: String, listener: APIListener) {
        val call: Call<HeaderModel> = mRemote.login(email, password)
        //Sincrona - Usuário espera até a API retornar (pode ser que demore)

        //Assincrona
        call.enqueue(object : Callback<HeaderModel> {
            //Quando a comunicação não é feita com sucesso
            override fun onFailure(call: Call<HeaderModel>, t: Throwable) {
                listener.onFaliure(context.getString(R.string.ERROR_UNEXPECTED))
            }

            //Quando a comunicação é feita, mesmo retornando falha
            override fun onResponse(call: Call<HeaderModel>, response: Response<HeaderModel>) {
                if (response.code() != TaskConstants.HTTP.SUCCESS) {
                    val validation =
                        Gson().fromJson(response.errorBody()!!.string(), String::class.java)
                    listener.onFaliure(validation)
                }else{
                    response.body()?.let { listener.onSuccess(it) }
                }

            }
        })
    }
}