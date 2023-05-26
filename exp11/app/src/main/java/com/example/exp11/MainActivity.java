package com.example.exp11;

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

        EditText to = findViewById(R.id.to);
        EditText sub = findViewById(R.id.sub);
        EditText msg = findViewById(R.id.msg);
        Button btn = findViewById(R.id.submit);

        btn.setOnClickListener((evt) -> {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.putExtra(Intent.EXTRA_EMAIL, to.getText().toString());
            i.putExtra(Intent.EXTRA_SUBJECT, sub.getText().toString());
            i.putExtra(Intent.EXTRA_TEXT, msg.getText().toString());
            i.setType("message/rfc822");
            startActivity(Intent.createChooser(i , "Choose Email App"));
        });
    }
}