package com.example.oop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class OOPActivity : AppCompatActivity() {

    lateinit var currentMenu : ScreenUI

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oop)
        val menu1 = findViewById<Button>(R.id.menu1)
        val menu2 = findViewById<Button>(R.id.menu2)
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val textView = findViewById<TextView>(R.id.text_view)

        val menuListener = View.OnClickListener{
            when(it){
                menu1 -> currentMenu = Menu1()
                menu2 -> currentMenu = Menu2()
            }
            currentMenu.show(textView)
        }
        val buttonListener = View.OnClickListener{
            when(it){
                button1 -> {
                    currentMenu.applyButton1(textView)
                }
                button2 -> {
                    currentMenu.applyButton2(textView)
                }
            }
        }

        menu1.setOnClickListener(menuListener)
        menu2.setOnClickListener(menuListener)
        button1.setOnClickListener(buttonListener)
        button2.setOnClickListener(buttonListener)
    }
}



