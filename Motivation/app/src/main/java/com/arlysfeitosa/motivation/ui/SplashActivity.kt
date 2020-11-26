package com.arlysfeitosa.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.arlysfeitosa.motivation.Infra.SecurityPreferences
import com.arlysfeitosa.motivation.R
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var securityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        buttonSave.setOnClickListener(this)

        securityPreferences = SecurityPreferences(this)
    }

    override fun onClick(v: View?) {
        if (v!!.id == R.id.buttonSave) {
            handleSave()
        }
    }

    private fun handleSave() {
        val name = editName.text.toString()

        if (name != "") {
            securityPreferences.storeString("name", name)
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            Toast.makeText(applicationContext, "Informe seu nome", Toast.LENGTH_SHORT).show()
        }
    }
}