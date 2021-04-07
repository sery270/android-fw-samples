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

        // TextWatcher의 메서드들은 화면이 바뀔때 호출되는 것이 아니다.
        // TextView 의 확인해보니, 그 setText()가 호출되면 TextWatcher의 메서드들이 차례로 호출된다.
        // 즉 실제 내가 지금 설명하려는 invalidate() 호출의 관계없이, onTextChanged()는 setText()가 호출되면 항상 호출된다.
//        findViewById<TextView>(R.id.text_view).addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                Log.d("beforeTextChanged", SystemClock.uptimeMillis().toString())
//            }
//
//            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                Log.d("onTextChanged", SystemClock.uptimeMillis().toString())
//            }
//
//            override fun afterTextChanged(p0: Editable?) {
//                Log.d("afterTextChanged", SystemClock.uptimeMillis().toString())
//            }
//
//
//        })

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