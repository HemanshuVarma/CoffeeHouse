package com.varma.hemanshu.coffeehouse

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper

/**
 * This is an Splash Activity with delay of 2 Sec.
 */
class SplashActivity : Activity() {
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_splash)
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, UserDetails::class.java))
            finish()
        }, 2000)
    }
}