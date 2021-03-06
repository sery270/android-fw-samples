package com.example.handlersamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.concurrent.timerTask

class HandlerPost : AppCompatActivity() {

    var handler2 = Handler(Looper.getMainLooper())

    private var value = 0
    private lateinit var textView : TextView
    private lateinit var button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_handler_post)
        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)
        button.setOnClickListener {

            Thread(object : Runnable {
                var isRun = false
                override fun run() {
                    isRun = true

                    while (isRun) {
                        value += 1

                        handler2.post { textView.text = "현재값 : $value" }
                        try {
                            Thread.sleep(1000)
                        } catch (e: Exception) {
                        }
                    }
                }
            }).start() //start()붙이면 바로실행
        }
    }
    private var isBackPressedOnce = false

    override fun onBackPressed() {
        if (isBackPressedOnce) {
            super.onBackPressed()
        } else {
            Toast.makeText(this, "앱을 종료하시려면 한 번 더 누르십시오 !", Toast.LENGTH_SHORT).show()
            isBackPressedOnce = true
            Handler(Looper.getMainLooper()).postDelayed(
                timerTask {

                    isBackPressedOnce = false

                }, 5000
            )
        }
    }
}