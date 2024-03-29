package com.example.tasks.service.repository.remote

import com.example.tasks.service.model.TaskModel
import retrofit2.Call
import retrofit2.http.*

//Métodos do serviço de atividades
interface TaskService {
    @GET("Task")
    fun all(): Call<List<TaskModel>>

    @GET("Task/Next7Days")
    fun nextWeek(): Call<List<TaskModel>>

    @GET("Task/Overdue")
    fun overdue(): Call<List<TaskModel>>

    @GET("Task/{id}")
    fun load(@Path(value = "id", encoded = true) id: Int): Call<TaskModel>
    //@Path(value = "valor no get", encoded = true //tratar espaços) param: T

    @POST("Task")
    @FormUrlEncoded
    fun create(
        @Field("PriorityId") priorityId: Int,
        @Field("Description") description: String,
        @Field("DueDate") dueDate: String,
        @Field("Complete") complete: Boolean
    ): Call<Boolean>

    @HTTP(method = "PUT", path = "Task", hasBody = true)
    @FormUrlEncoded
    fun update(
        @Field("Id") Id: Int,
        @Field("PriorityId") priorityId: Int,
        @Field("Description") description: String,
        @Field("DueDate") dueDate: String,
        @Field("Complete") complete: Boolean
    ): Call<Boolean>

    @HTTP(method = "PUT", path = "Task/Complete", hasBody = true)
    @FormUrlEncoded
    fun complete(@Field("Id") Id: Int): Call<Boolean>

    @HTTP(method = "PUT", path = "Task/Undo", hasBody = true)
    @FormUrlEncoded
    fun undo(@Field("Id") Id: Int): Call<Boolean>

    @HTTP(method = "DELETE", path = "Task", hasBody = true)
    @FormUrlEncoded
    fun delete(@Field("Id") Id: Int): Call<Boolean>
}