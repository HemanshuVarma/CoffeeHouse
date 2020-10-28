package com.varma.hemanshu.coffeehouse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * This is an Splash Activity with delay of 2 Sec.
 */
public class SplashActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(SplashActivity.this, UserDetails.class));
                finish();
            }
        }, 2000);
    }
}
