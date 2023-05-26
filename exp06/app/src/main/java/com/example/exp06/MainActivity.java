package com.example.exp06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);
        Button thread1 = findViewById(R.id.thread1);
        Button thread2 = findViewById(R.id.thread2);

        thread1.setOnClickListener((evt) -> {
            runOnUiThread(() -> {
               textView.setText("Thread 1");
           });
        });

        thread2.setOnClickListener((evt) -> {
            runOnUiThread(() -> {
                textView.setText("Thread 2");
            });
        });
    }
}