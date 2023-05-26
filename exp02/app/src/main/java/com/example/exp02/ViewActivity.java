package com.example.exp02;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        String name = getIntent().getStringExtra("name");
        String reg = getIntent().getStringExtra("reg");

        TextView nameView = findViewById(R.id.nameview);
        TextView regView = findViewById(R.id.regview);

        nameView.setText(name);
        regView.setText(reg);
    }
}
