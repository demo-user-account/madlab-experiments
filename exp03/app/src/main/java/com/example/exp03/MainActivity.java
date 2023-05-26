package com.example.exp03;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bitmap bg = Bitmap.createBitmap(720, 1024, Bitmap.Config.ARGB_8888);
        ImageView image = findViewById(R.id.imageView);
        image.setBackground(new BitmapDrawable(this.getResources(), bg));

        Canvas canvas = new Canvas(bg);
        Paint paint = new Paint();
        paint.setColor(Color.YELLOW);

        canvas.drawRect(400, 200, 650, 700, paint);
    }
}