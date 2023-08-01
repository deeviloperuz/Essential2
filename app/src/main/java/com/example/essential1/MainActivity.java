package com.example.essential1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.essential1.MainActivity;
import com.example.essential1.R;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {
    Timer timer;
    private Class SecondActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,SecondActivity);
                startActivity(intent);
                finish();
            }
        }, 1500);
    }
}
