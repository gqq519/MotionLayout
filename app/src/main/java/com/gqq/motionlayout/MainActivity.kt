package com.gqq.motionlayout

import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import com.google.android.material.appbar.AppBarLayout
import kotlin.math.log

class MainActivity : AppCompatActivity() {


    companion object {
        private val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        setContentView(R.layout.activity_scroll)

        initUI()
        initWebView()

    }

    private fun initUI() {

        val appBarLayout: AppBarLayout = findViewById(R.id.appBarLayout)
        val motionLayout: MotionLayout = findViewById(R.id.motionLayout)

        val listener = AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            val seekPosition = -verticalOffset / appBarLayout.totalScrollRange.toFloat()
            motionLayout.progress = seekPosition

            Log.i(TAG, "initUI: $seekPosition")

        }
        appBarLayout.addOnOffsetChangedListener(listener)

    }

    private fun initWebView() {
        val webView: WebView = findViewById(R.id.webview)
        webView.loadUrl("https://www.xiaoyezi.com/html/xiaoyezi_user_service_agreement.html")
    }
}