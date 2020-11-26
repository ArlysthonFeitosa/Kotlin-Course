package com.arlysfeitosa.motivation.Infra

import android.content.Context
import android.content.SharedPreferences

class SecurityPreferences(val context: Context) {

    private val sharedPreferences:SharedPreferences = context.getSharedPreferences("motivation", Context.MODE_PRIVATE)

    fun storeString(key: String, value: String) {
        sharedPreferences.edit().putString(key,value).apply()
    }

    fun getString(key: String): String {
        return sharedPreferences.getString(key, "") ?: ""
    }
}