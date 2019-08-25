package com.example.servicenotificationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //khi khởi chạy ứng dụng chạy luôn service
        startService(new Intent(getBaseContext(), ServiceNotification.class));
    }
}
