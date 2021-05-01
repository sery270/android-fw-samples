package com.example.oop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class OOPActivity : AppCompatActivity() {


    private fun changeUIToMenu1(textView: TextView) {
        textView.text = "메뉴 1 입니다."
    }
    private fun changeUIToMenu2(textView: TextView) {
        textView.text = "메뉴 2 입니다."
    }

    private fun applyButton1WhenMenu1(textView: TextView) {
        textView.text = "요청이 메뉴 1에 적용되었습니다."
    }
    private fun applyButton1WhenMenu2(textView: TextView) {
        textView.text = "요청이 메뉴 2에 적용되었습니다."
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oop)
        val menu1 = findViewById<Button>(R.id.menu1)
        val menu2 = findViewById<Button>(R.id.menu2)
        val button1 = findViewById<Button>(R.id.button1)
        val textView = findViewById<TextView>(R.id.text_view)
        var currentMenu = 0

        menu1.setOnClickListener {
            currentMenu = 1
            changeUIToMenu1(textView)
        }
        menu2.setOnClickListener {
            currentMenu = 2
            changeUIToMenu2(textView)
        }
        button1.setOnClickListener {
            when(currentMenu){
                0 -> return@setOnClickListener
                1 -> applyButton1WhenMenu1(textView)
                2 -> applyButton1WhenMenu2(textView)
            }
        }

    }
}

