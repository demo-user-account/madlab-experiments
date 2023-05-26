package com.example.exp04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.app.AlertDialog.Builder;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = openOrCreateDatabase("MyDB", Context.MODE_PRIVATE, null);

        db.execSQL("CREATE TABLE IF NOT EXISTS PERSON( name VARCHAR )");

        EditText text = findViewById(R.id.input);
        Button insert = findViewById(R.id.insert);
        Button view = findViewById(R.id.view);

        insert.setOnClickListener((evt) -> {
            db.execSQL("INSERT INTO PERSON VALUES ( '" + text.getText() + "' )");
        });

        view.setOnClickListener((evt) -> {
            Cursor c = db.rawQuery("SELECT * FROM PERSON", null);
            StringBuilder buffer = new StringBuilder();

            while (c.moveToNext()) {
                buffer.append(c.getString(0)).append("\n");
            }

            c.close();
            this.showMessage("Persons", buffer.toString());
        });
    }

    private void showMessage(String title, String msg) {
        Builder builder = new Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.show();
    }
}