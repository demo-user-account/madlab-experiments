package com.example.exp01;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textcomp = findViewById(R.id.textcomp);
        Button btnFont = findViewById(R.id.btnfont);
        Button btncol = findViewById(R.id.btncol);

        btnFont.setOnClickListener((evt) -> {
            textcomp.setTextSize(TypedValue.COMPLEX_UNIT_PX,textcomp.getTextSize() + 1);
        });

        btncol.setOnClickListener((evt) -> {
            if (textcomp.getCurrentTextColor() == Color.WHITE) {
                textcomp.setTextColor(Color.BLUE);
            } else {
                textcomp.setTextColor(Color.WHITE);
            }
        });
    }
}
