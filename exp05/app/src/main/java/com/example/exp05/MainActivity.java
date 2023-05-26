package com.example.exp05;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private NotificationManager nm;
    private NotificationChannel channel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button show = findViewById(R.id.button);

        nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        channel = new NotificationChannel("1", "hello", NotificationManager.IMPORTANCE_DEFAULT);
        nm.createNotificationChannel(channel);

        show.setOnClickListener((evt) -> {
            NotificationCompat.Builder  builder = new NotificationCompat.Builder(MainActivity.this, channel.getId())
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setContentTitle("Hello, World")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setContentText("Content");

            nm.notify(1, builder.build());
        });
    }
}
