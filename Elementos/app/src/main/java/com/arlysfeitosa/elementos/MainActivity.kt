package com.arlysfeitosa.elementos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imgView = findViewById<ImageView>(R.id.imgView)
        val checkBox = findViewById<CheckBox>(R.id.check)

    }

    fun onClick(v: View) {
        val imgView = findViewById<ImageView>(R.id.imgView)
        val checkBox = findViewById<CheckBox>(R.id.check)
        if (checkBox.isChecked) {
            imgView.setColorFilter(resources.getColor(R.color.teal_200))
        } else imgView.setColorFilter(resources.getColor(R.color.teal_700))
    }
}