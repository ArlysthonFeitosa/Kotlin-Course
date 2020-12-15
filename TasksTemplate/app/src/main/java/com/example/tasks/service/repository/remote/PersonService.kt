package com.example.tasks.service.repository.remote

import com.example.tasks.service.model.HeaderModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

//Interface API
interface PersonService {
    //Implementando serviços da API
    @POST("Authentication/Login")
    @FormUrlEncoded //Formato de dados para passar pra API
    fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<HeaderModel>
    //Header Model - Modelo dos dados vindo da API

    @POST("Authentication/Create")
    @FormUrlEncoded //Formato de dados para passar pra API
    fun create(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("receiveNews") news: Boolean
    ): Call<HeaderModel>
    //Header Model - Modelo dos dados vindo da API
}