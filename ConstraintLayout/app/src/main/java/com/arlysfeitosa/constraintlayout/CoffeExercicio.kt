package com.arlysfeitosa.constraintlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar

class CoffeExercicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coffe_exercicio)


        if(supportActionBar != null) supportActionBar!!.hide()

    }
}