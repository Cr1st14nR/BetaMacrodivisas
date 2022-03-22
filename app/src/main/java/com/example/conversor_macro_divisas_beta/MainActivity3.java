package com.example.conversor_macro_divisas_beta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        tv = (TextView)findViewById(R.id.TV_escritura);
        String nota = getIntent().getStringExtra("escrito");
        tv.setText(nota);
    }

    public void volverinicio3 (View view) {

        Intent inicio = new Intent(this, MainActivity.class);
        startActivity(inicio);

    }

    public void volverdocumentacion (View view) {

        Intent documenta = new Intent(this, MainActivity2.class);
        startActivity(documenta);

    }

}