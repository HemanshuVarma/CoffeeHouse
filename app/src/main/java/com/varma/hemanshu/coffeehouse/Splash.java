package com.varma.hemanshu.coffeehouse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * This is an Splash Activity with delay of 4 Sec.
 */
public class Splash extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(Splash.this, UserDetails.class));
                finish();
            }
        }, 4000);
    }
}
