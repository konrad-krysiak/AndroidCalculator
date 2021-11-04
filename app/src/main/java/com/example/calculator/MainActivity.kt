package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {
    lateinit var tv : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv = findViewById(R.id.tv)
    }

    fun buttonHandler(view: View) {
        tv.append((view as Button).text)
    }

    fun equalsHandler(view: View) {
        val text = tv.text.toString()
        val exp = ExpressionBuilder(text).build()
        try {
            val result = exp.evaluate().toString()
            tv.setText(result)
        } catch(e: ArithmeticException) {
            tv.setText("Error")
        }
    }

    fun clearHandler(view: View) {
        tv.setText("")
    }


}