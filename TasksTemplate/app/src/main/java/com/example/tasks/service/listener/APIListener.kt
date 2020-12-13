package com.example.tasks.service.listener

import com.example.tasks.service.HeaderModel

interface APIListener {
    fun onSuccess(model: HeaderModel)
    fun onFaliure(str: String)
}