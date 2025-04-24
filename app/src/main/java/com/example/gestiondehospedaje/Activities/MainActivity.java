package com.example.gestiondehospedaje.Activities;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gestiondehospedaje.Adaptadores.ReservaAdapter;
import com.example.gestiondehospedaje.R;
import com.example.gestiondehospedaje.Activities.Reserva;
import com.example.gestiondehospedaje.Activities.ReservaCholet;
import com.example.gestiondehospedaje.Activities.ReservaCamping;
import com.example.gestiondehospedaje.Activities.ReservaHotel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ReservaAdapter adapter;
    private List<Reserva> listaReservas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerReservas);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listaReservas = obtenerReservasEjemplo();

        adapter = new ReservaAdapter(this, listaReservas);
        recyclerView.setAdapter(adapter);
    }

    private List<Reserva> obtenerReservasEjemplo() {
        List<Reserva> lista = new ArrayList<>();

        lista.add(new ReservaHotel(
                "R001", "María González", "2024-06-15", "2024-06-20", 550.0,
                "Suite Presidencial", true, 2));

        lista.add(new ReservaCholet(
                "R002", "Juan Martínez", "2024-07-05", "2024-07-10", 350.0,
                70, true, 4));

        lista.add(new ReservaCamping(
                "R003", "Sofía Ramírez", "2024-08-12", "2024-08-15", 750.0,
                45, false, 2,
                25,Arrays.asList("Piscina", "Senderismo", "Fogata nocturna"),R.drawable.camping));

        lista.add(new ReservaHotel(
                "R004", "Pedro Sánchez", "2024-09-01", "2024-09-04", 480.0,
                "Suite Ejecutiva", false, 2));

        lista.add(new ReservaCholet(
                "R005", "Lucía Fernández", "2024-10-20", "2024-10-23", 320.0,
                65, false, 3));
        lista.add(new ReservaCamping(
                "R006", "Pablo Rocabado", "2024-12-16", "2025-01-10", 7150.0,
                45, false, 2,
                1000,Arrays.asList("Piscina", "Senderismo", "Fogata nocturna"),R.drawable.camping));
        lista.add(new ReservaHotel(
                "R007", "Pancrasio Perez", "2024-02-15", "2024-07-20", 550.0,
                "Suite Presidencial", true, 2));

        return lista;
    }
}