package com.example.handlersamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*
import kotlin.concurrent.timerTask

class BackgroundThread : AppCompatActivity() {

    private var value = 0
    private lateinit var textView: TextView
    private lateinit var button: Button
    private lateinit var button2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_background_thread)
        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)
        button2 = findViewById(R.id.button2)

        button.setOnClickListener {
            val thread: BackgroundThread = BackgroundThread()
            thread.start()
        }
        button2.setOnClickListener {
            textView.text = "현재 값 : $value"
        }
    }

    //스레드 구현한 객체
    internal inner class BackgroundThread : Thread() {
        var isRun = false
        override fun run() {
            isRun = true
            //1초마다 벨류값 1씩 증가시키는 스레드
            while (isRun) {
                value++
                // 여기서 아래 코드 동작 결과는 ?
                // 에러남 !
//                textView.text = "현재 값 : $value"
                try {
                    sleep(1000)
                } catch (e: Exception) {
                }
            }
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

