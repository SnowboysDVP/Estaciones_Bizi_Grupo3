package com.ijuste.estaciones_bizi_grupo3.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.ijuste.estaciones_bizi_grupo3.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler handler = new Handler(Looper.myLooper());

        handler.postDelayed(()-> {
            Intent intent = new Intent(getApplicationContext(), ListadoActivity.class);
            startActivity(intent);
            finish();
        }, 1500);
    }

    }
