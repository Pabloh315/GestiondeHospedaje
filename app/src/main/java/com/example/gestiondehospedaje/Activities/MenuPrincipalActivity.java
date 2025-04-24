package com.example.gestiondehospedaje.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gestiondehospedaje.R;

public class MenuPrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        ImageButton btnReservas = findViewById(R.id.btnReservas);
        btnReservas.setOnClickListener(v -> {
            Intent intent = new Intent(MenuPrincipalActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
} 