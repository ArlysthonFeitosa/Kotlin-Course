package com.example.tasks.service.listener

import com.example.tasks.service.model.HeaderModel

//Intermédio da API
interface APIListener {
    fun onSuccess(model: HeaderModel) //Modelo retornado corretamente
    fun onFaliure(str: String) //Erro
}