package com.example.tasks.service.repository

import android.content.Context
import com.example.tasks.R
import com.example.tasks.service.model.HeaderModel
import com.example.tasks.service.constants.TaskConstants
import com.example.tasks.service.listener.APIListener
import com.example.tasks.service.repository.remote.PersonService
import com.example.tasks.service.repository.remote.RetrofitClient
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//Repositório de operações na API
class PersonRepository(val context: Context) {

    //Retrofit
    private val mRemote = RetrofitClient.createService(PersonService::class.java)

    //Login a partir da API
    fun login(email: String, password: String, listener: APIListener) {

        //Preparando chamada de login vindo da API
        val call: Call<HeaderModel> = mRemote.login(email, password)

        //Sincrona - Usuário espera até a API retornar (pode ser que demore)

        //Enqueue - Uma chamada assincrona vindo da API
        call.enqueue(object : Callback<HeaderModel> {
            //Quando a comunicação não é feita com sucesso
            override fun onFailure(call: Call<HeaderModel>, t: Throwable) {
                listener.onFaliure(context.getString(R.string.ERROR_UNEXPECTED))
            }

            //Quando a comunicação é feita, mesmo retornando falha
            override fun onResponse(call: Call<HeaderModel>, response: Response<HeaderModel>) {
                //Se a resposta for diferente de 200 (sucesso)
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

    fun create(name: String, email: String, password: String, listener: APIListener) {

        //Preparando chamada de criação de usuário vindo da API
        val call: Call<HeaderModel> = mRemote.create(name, email, password, false)

        //Sincrona - Usuário espera até a API retornar (pode ser que demore)

        //Enqueue - Uma chamada assincrona vindo da API
        call.enqueue(object : Callback<HeaderModel> {
            //Quando a comunicação não é feita com sucesso
            override fun onFailure(call: Call<HeaderModel>, t: Throwable) {
                listener.onFaliure(context.getString(R.string.ERROR_UNEXPECTED))
            }

            //Quando a comunicação é feita, mesmo retornando falha
            override fun onResponse(call: Call<HeaderModel>, response: Response<HeaderModel>) {
                //Se a resposta for diferente de 200 (sucesso)
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