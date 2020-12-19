package com.example.tasks.service.repository.remote


import com.example.tasks.service.model.PriorityModel
import retrofit2.Call
import retrofit2.http.GET

//Métodos do serviço de prioridade de tarefas
interface PriorityService {
    @GET("Priority")
    fun list(): Call<List<PriorityModel>>
}