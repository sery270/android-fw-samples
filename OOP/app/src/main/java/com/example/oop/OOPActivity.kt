package com.example.oop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class OOPActivity : AppCompatActivity() {

    // Menu~로 정의된 클래스들은 Menu의 행동이 정의된 ScreenUI를 상속받았다.
    lateinit var currentMenu : ScreenUI

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oop)
        val menu1 = findViewById<Button>(R.id.menu1)
        val menu2 = findViewById<Button>(R.id.menu2)
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val textView = findViewById<TextView>(R.id.text_view)

        // 코틀린에서 함수는 값이다.
        val menuListener = View.OnClickListener{
            currentMenu = when(it){
                menu1 -> Menu1()
                menu2 -> Menu2()
                else -> return@OnClickListener
            }

            // ScreenUI를 통해 Menu의 행동을 정의했다.
            // Menu인 currentMenu는 자신이 어떤 Menu인지 알필요 없이,
            // (when의 결과에 상관 없이),
            // Menu로써 정의된 행동을 수행하기만 하면 된다.
            currentMenu.show(textView)
        }
        val buttonListener = View.OnClickListener{
            // menuListener와는 달리 현재 클릭된 버튼이
            // button1인지 button2인지에 따라
            // currentMenu 에서 어떤 행동을 해야할지 달라진다.
            // 각 Menu의 행동마다 각 button에 대한 행동이 정의되어있기 때문이다.
            if (::currentMenu.isInitialized) {
                when (it) {
                    button1 -> {
                        currentMenu.applyButton1(textView)
                    }
                    button2 -> {
                        currentMenu.applyButton2(textView)
                    }
                }
            } else{
                textView.text = "메뉴를 선택해주세요."
            }

        }

        menu1.setOnClickListener(menuListener)
        menu2.setOnClickListener(menuListener)
        button1.setOnClickListener(buttonListener)
        button2.setOnClickListener(buttonListener)
    }
}



