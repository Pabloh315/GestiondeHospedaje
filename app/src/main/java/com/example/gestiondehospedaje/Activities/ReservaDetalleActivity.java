package com.example.gestiondehospedaje.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gestiondehospedaje.R;

public class ReservaDetalleActivity extends AppCompatActivity {
    private TextView tvDetalle;
    private TextView tvDetalleCompleto;
    private ImageView ivCamping;
    private TextView tvCostoPorPersona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_detalle);

        tvDetalle = findViewById(R.id.tvDetalle);
        tvDetalleCompleto = findViewById(R.id.tvDetalleCompleto);
        ivCamping = findViewById(R.id.ivCamping);
        tvCostoPorPersona = findViewById(R.id.tvCostoPorPersona);

        Reserva reserva = (Reserva) getIntent().getSerializableExtra("reserva");
        if (reserva != null) {
            mostrarDetalleReserva(reserva);
        }
    }

    private void mostrarDetalleReserva(Reserva reserva) {
        // Ocultar elementos específicos de camping por defecto
        ivCamping.setVisibility(View.GONE);
        tvCostoPorPersona.setVisibility(View.GONE);

        StringBuilder detalle = new StringBuilder();
        detalle.append("Código: ").append(reserva.getCodigo()).append("\n");
        detalle.append("Cliente: ").append(reserva.getCliente()).append("\n");
        detalle.append("Fecha Entrada: ").append(reserva.getFechaEntrada()).append("\n");
        detalle.append("Fecha Salida: ").append(reserva.getFechaSalida()).append("\n");
        detalle.append("Precio Total: $").append(reserva.getPrecioTotal()).append("\n");

        switch (reserva.getTipo()) {
            case "hotel":
                ReservaHotel hotel = (ReservaHotel) reserva;
                detalle.append("Tipo de Habitación: ").append(hotel.getTipoHabitacion()).append("\n");
                detalle.append("Incluye Desayuno: ").append(hotel.isIncluyeDesayuno() ? "Sí" : "No").append("\n");
                detalle.append("Número de Huéspedes: ").append(hotel.getNumeroHuespedes());
                break;

            case "cholet":
                ReservaCholet cholet = (ReservaCholet) reserva;
                detalle.append("Metros Cuadrados: ").append(cholet.getMetrosCuadrados()).append("\n");
                detalle.append("Tiene Jardín: ").append(cholet.isTieneJardin() ? "Sí" : "No").append("\n");
                detalle.append("Número de Habitaciones: ").append(cholet.getNumeroHabitaciones());
                break;

            case "camping":
                ReservaCamping camping = (ReservaCamping) reserva;
                detalle.append("Metros Cuadrados: ").append(camping.getMetrosCuadrados()).append("\n");
                detalle.append("Tiene Electricidad: ").append(camping.isTieneElectricidad() ? "Sí" : "No").append("\n");
                detalle.append("Número de Personas: ").append(camping.getNumeroPersonas()).append("\n");
                detalle.append("Tipo de Camping: ").append(camping.getTipoCamping()).append("\n");
                detalle.append("Actividades: ").append(String.join(", ", camping.getActividades()));

                // Mostrar información específica de camping
                ivCamping.setVisibility(View.VISIBLE);
                tvCostoPorPersona.setVisibility(View.VISIBLE);
                tvCostoPorPersona.setText("Costo por persona: $" + camping.getCostoPorPersona());
                break;
        }

        tvDetalleCompleto.setText(detalle.toString());
    }
}
