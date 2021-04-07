package com.example.invalidate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.HandlerThread
import android.os.SystemClock
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button).setOnClickListener {
            Log.d("setOnClickListener", SystemClock.uptimeMillis().toString())
            onClick(findViewById<TextView>(R.id.text_view))
        }



//        GlobalScope.launch {
//            check(findViewById<TextView>(R.id.text_view))
//        }


    }

    fun onClick(view: TextView) {
        for (i in 0..4) {
            view.text = i.toString()
            Log.d("for 문 ${i}번째", SystemClock.uptimeMillis().toString())
            SystemClock.sleep(1000)
        }

    }

//    fun check(view: TextView){
//        while (true){
//            if (view.text.toString() == "4") {
//                Log.d("check ! ", SystemClock.uptimeMillis().toString())
//                break
//            }
//        }
//    }
}