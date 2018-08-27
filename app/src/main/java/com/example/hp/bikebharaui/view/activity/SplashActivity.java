package com.example.hp.bikebharaui.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.hp.bikebharaui.MainActivity;
import com.example.hp.bikebharaui.R;


public class SplashActivity extends Activity {

    // this activity is made for splash screen which is supposed to pop up when the app starts

    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        handler=new Handler(); //handler class called, handlers can basically communicate with UI and is a background thread
        //handler.postDelayed will call run method of runnable after set time and redirect to main app screen.
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);

    }



}
