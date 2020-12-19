package com.example.tasks.service.model

import com.google.gson.annotations.SerializedName

//Modelo da pessoa no login
class HeaderModel {
    @SerializedName("token")
    var token: String = ""

    @SerializedName("personKey")
    var personKey: String = ""

    @SerializedName("name")
    var name: String = ""
}