package com.example.tasks.service.listener

import com.example.tasks.service.model.HeaderModel

//Intermédio da API
interface APIListener<T> {
    fun onSuccess(model: T) //Modelo retornado corretamente
    fun onFaliure(str: String) //Erro
}