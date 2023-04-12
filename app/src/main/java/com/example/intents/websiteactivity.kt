package com.example.intents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class websiteactivity : AppCompatActivity() {
    lateinit var myweb:WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_websiteactivity)

        myweb = findViewById(R.id.mweb)
        val webSettings = myweb.settings
        webSettings.javaScriptEnabled = true
        myweb.loadUrl("https://apple.com")
    }
}