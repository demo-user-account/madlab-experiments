package com.example.exp02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText name = findViewById(R.id.name);
        EditText reg = findViewById(R.id.reg);
        Button nxt = findViewById(R.id.nxt);

        nxt.setOnClickListener((evt) -> {
            Intent i = new Intent(MainActivity.this, ViewActivity.class);
            i.putExtra("name", name.getText().toString());
            i.putExtra("reg", reg.getText().toString());
            startActivity(i);
        });
    }
}
