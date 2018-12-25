package com.example.hasnain.bmicalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        calculateButton.setOnClickListener {
            val w:Float = weight.text.toString().toFloat()
            val h:Float = height.text.toString().toFloat()
            output.text = "Your BMI is %.2f".format(w/(h*h))
        }
    }
}