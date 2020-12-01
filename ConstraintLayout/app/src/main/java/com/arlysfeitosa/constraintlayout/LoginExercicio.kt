package com.arlysfeitosa.constraintlayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class LoginExercicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_exercicio)
    }

    fun onCLickLogin(view: View){
        startActivity(Intent(this, CoffeExercicio::class.java)).apply{}
        finish()
    }
}