package com.example.handlersamples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.concurrent.timerTask


class HandlerSend : AppCompatActivity() {

    var handler = ValueHandler()

    private var value = 0
    private lateinit var textView : TextView
    private lateinit var button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_handler_send)
        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)
        button.setOnClickListener {
            val thread = BackgroundThread()
            thread.start()
        }
    }

    //스레드 객체
    internal inner class BackgroundThread : Thread() {
        var isRun = false
        override fun run() {
            isRun = true
            //1초마다 벨류값 1씩 증가시키는 스레드
            while (isRun) {
                value += 1

                val message = handler.obtainMessage()
                val bundle = Bundle()
                bundle.putInt("value", value)
                message.data = bundle

                handler.sendMessage(message)
                try {
                    sleep(1000)
                } catch (e: Exception) {
                }
            }
        }
    }

    //핸들러 객체(핸들러 역할 부여)
    inner class ValueHandler : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            val bundle = msg.data
            val value = bundle.getInt("value")
            textView!!.text = "현재 값 : $value" //핸들러를 이용해 스레드에서 UI접근 가능
        }
    }
    private var isBackPressedOnce = false

    override fun onBackPressed() {
        if (isBackPressedOnce) {
            super.onBackPressed()
        } else {
            Toast.makeText(this, "앱을 종료하시려면 한 번 더 누르십시오 !", Toast.LENGTH_SHORT).show()
            isBackPressedOnce = true
            Handler().postDelayed(
                timerTask {

                    isBackPressedOnce = false

                }, 5000
            )
        }
    }
}