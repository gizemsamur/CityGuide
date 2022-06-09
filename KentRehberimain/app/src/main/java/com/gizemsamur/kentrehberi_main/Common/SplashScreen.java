package com.gizemsamur.kentrehberi_main.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.gizemsamur.kentrehberi_main.Common.LoginSignUp.Startup_Screen;
import com.gizemsamur.kentrehberi_main.R;
import com.gizemsamur.kentrehberi_main.User.UserDashboard;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIMER = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(getApplicationContext(), Startup_Screen.class);
                startActivity(intent);
                finish();

            }
        },SPLASH_TIMER);


    }
}