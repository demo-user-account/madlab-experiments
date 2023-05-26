package com.example.exp08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.StandardOpenOption;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText content = findViewById(R.id.content);
        Button read = findViewById(R.id.read);
        Button write = findViewById(R.id.write);

        read.setOnClickListener((evt) -> {
            File file = new File(Environment.getExternalStorageDirectory().getPath() + "/exp08.txt");
            try {
                content.setText(String.join("\n", Files.readAllLines(file.toPath())));
            } catch (IOException e) {
                Toast toast = new Toast(this);
                toast.setText("File Error");
                toast.show();
                e.printStackTrace();
            }
        });
        write.setOnClickListener((evt) -> {
            File file = new File(Environment.getExternalStorageDirectory().getPath() + "/exp08.txt");
            try {
                Files.write(file.toPath(), content.getText().toString().getBytes(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
            } catch (IOException e) {
                Toast toast = new Toast(this);
                toast.setText("File Error");
                toast.show();
                e.printStackTrace();
            }
        });
    }
}