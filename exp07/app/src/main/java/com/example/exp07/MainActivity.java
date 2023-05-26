package com.example.exp07;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);

        button.setOnClickListener((evt) -> {
            LocationManager lm = (LocationManager) getSystemService(LOCATION_SERVICE);
            Toast toast = new Toast(this);
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                toast.setText("Persmission denied");
                toast.show();
                return;
            }
            Location ll = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (ll == null) {
                toast.setText("Not found");
                toast.show();
                return;
            }

            double lat = ll.getLatitude();
            double lon = ll.getLongitude();

            toast.setText("lat: " + String.valueOf(lat) + "\n" + "lon: " + String.valueOf(lon));
            toast.show();
        });
    }
}
