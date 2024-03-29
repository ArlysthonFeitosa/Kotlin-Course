package com.example.tasks.service.repository.remote

import com.example.tasks.service.constants.TaskConstants
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Singleton para chamada de serviço Retrofit
class RetrofitClient private constructor() {

    companion object {
        private lateinit var retrofit: Retrofit
        private val baseUrl = "http://devmasterteam.com/CursoAndroidAPI/"
        private var personKey = ""
        private var tokenKey = ""

        private fun getRetrofitInstance(): Retrofit {
            //httpClient faz a chamada
            val httpClient = OkHttpClient.Builder()
            //É possível colocar alguém que intercepta a chamada
            httpClient.addInterceptor { chain -> //Chain, a requisição que está ocorrendo e adiciona os interceptadores
                val request =
                    chain.request()
                        .newBuilder()
                        .addHeader(TaskConstants.HEADER.PERSON_KEY, personKey)
                        .addHeader(TaskConstants.HEADER.TOKEN_KEY, tokenKey)
                        .build()
                chain.proceed(request)
            }

            if (!Companion::retrofit.isInitialized) {
                retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(httpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }

        fun addHeader(token: String, personKey: String) {
            this.personKey = personKey
            this.tokenKey = token
        }

        fun <T> createService(serviceClass: Class<T>): T {
            return getRetrofitInstance()
                .create(serviceClass)
        }
    }
}