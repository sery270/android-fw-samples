package com.example.oop

import android.widget.TextView

class Menu2 : ScreenUI {
    // changeUIToMenu2
    override fun show(textView: TextView) {
        textView.text = "메뉴 2 입니다."
    }

    override fun applyButton1(textView: TextView) {
        textView.text = "Button1 요청이 메뉴 2에 적용되었습니다."
    }

    override fun applyButton2(textView: TextView) {
        textView.text = "Button2 요청이 메뉴 2에 적용되었습니다."
    }
}