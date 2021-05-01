package com.example.oop

import android.widget.TextView

interface ScreenUI {
    fun show(textView: TextView)
    fun applyButton1(textView: TextView)
    fun applyButton2(textView: TextView)
}