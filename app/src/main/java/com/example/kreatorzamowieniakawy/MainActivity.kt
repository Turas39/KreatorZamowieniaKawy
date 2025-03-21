package com.example.kreatorzamowieniakawy

import android.os.Bundle
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val seekBar = findViewById<SeekBar>(R.id.ilosc_seekbar)
        val textview = findViewById<TextView>(R.id.ilosc_textview)
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                textview.text = "$progress"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })

        val kawaImageView = findViewById<ImageView>(R.id.kawa_imageview)
        val kawaRadioGroup = findViewById<RadioGroup>(R.id.kawa_radiogroup)
        val cappucinoRadioButton = findViewById<RadioButton>(R.id.cappuccino_radiobutton)

        cappucinoRadioButton.isChecked = true

        val images = listOf(
            R.drawable.latte,
            R.drawable.espresso,
            R.drawable.capuccino
        )

        kawaRadioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.latte_radiobutton -> kawaImageView.setImageResource(R.drawable.latte)
                R.id.espresso_radiobutton -> kawaImageView.setImageResource(R.drawable.espresso)
                R.id.cappuccino_radiobutton -> kawaImageView.setImageResource(R.drawable.capuccino)
            }
        }

    }
}