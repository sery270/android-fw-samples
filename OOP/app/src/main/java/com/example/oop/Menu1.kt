package com.example.oop

import android.widget.TextView

class Menu1 : ScreenUI {
    // changeUIToMenu1
    override fun show(textView: TextView) {
        textView.text = "메뉴 1 입니다."
    }

    override fun applyButton1(textView: TextView) {
        textView.text = "Button1 요청이 메뉴 1에 적용되었습니다."
    }

    override fun applyButton2(textView: TextView) {
        textView.text = "Button2 요청이 메뉴 1에 적용되었습니다."
    }


}