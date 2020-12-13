package com.example.tasks.service

import com.google.gson.annotations.SerializedName

class HeaderModel {

    @SerializedName("token")
    var token: String = ""

    @SerializedName("personkey")
    var personKey: String = ""

    @SerializedName("name")
    var name: String = ""
}