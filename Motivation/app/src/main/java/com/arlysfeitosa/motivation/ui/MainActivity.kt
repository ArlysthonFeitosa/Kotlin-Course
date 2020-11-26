package com.arlysfeitosa.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arlysfeitosa.motivation.Infra.MotivationConstants
import com.arlysfeitosa.motivation.Infra.SecurityPreferences
import com.arlysfeitosa.motivation.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var securityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        securityPreferences = SecurityPreferences(this)
        textName.text = securityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)
    }
}