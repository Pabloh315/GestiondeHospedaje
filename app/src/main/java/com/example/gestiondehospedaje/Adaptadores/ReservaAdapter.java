package com.example.gestiondehospedaje.Adaptadores;
import com.example.gestiondehospedaje.Activities.Reserva;
import com.example.gestiondehospedaje.Activities.ReservaDetalleActivity;
import com.example.gestiondehospedaje.Activities.ReservaHotel;
import com.example.gestiondehospedaje.Activities.ReservaCholet;
import com.example.gestiondehospedaje.Activities.ReservaCamping;
import com.example.gestiondehospedaje.R;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ReservaAdapter extends RecyclerView.Adapter<ReservaAdapter.ReservaViewHolder> {
    private Context context;
    private List<Reserva> listaReservas;

    public ReservaAdapter(Context context, List<Reserva> listaReservas) {
        this.context = context;
        this.listaReservas = listaReservas;
    }

    @NonNull
    @Override
    public ReservaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(context).inflate(R.layout.item_reserva, parent, false);
        return new ReservaViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ReservaViewHolder holder, int position) {
        Reserva reserva = listaReservas.get(position);

        holder.tvTipo.setText("Tipo: " + reserva.getTipo());
        holder.tvCliente.setText("Cliente: " + reserva.getCliente());
        holder.tvFechas.setText("Del " + reserva.getFechaEntrada() + " al " + reserva.getFechaSalida());

        // Ocultar vistas específicas de camping por defecto
        holder.ivCamping.setVisibility(View.GONE);
        holder.tvCostoPorPersona.setVisibility(View.GONE);

        // Colores según tipo
        switch (reserva.getTipo()) {
            case "hotel":
                holder.itemView.setBackgroundColor(Color.parseColor("#E3F2FD")); // Azul claro
                break;
            case "cholet":
                holder.itemView.setBackgroundColor(Color.parseColor("#E8F5E9")); // Verde claro
                break;
            case "camping":
                holder.itemView.setBackgroundColor(Color.parseColor("#F3E5F5")); // Morado claro
                // Mostrar información específica de camping
                holder.ivCamping.setVisibility(View.VISIBLE);
                holder.tvCostoPorPersona.setVisibility(View.VISIBLE);
                ReservaCamping reservaCamping = (ReservaCamping) reserva;
                holder.tvCostoPorPersona.setText("Costo por persona: $" + reservaCamping.getCostoPorPersona());
                break;
            default:
                holder.itemView.setBackgroundColor(Color.WHITE);
        }

        // Click para detalle
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ReservaDetalleActivity.class);
            intent.putExtra("reserva", reserva);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return listaReservas.size();
    }

    public static class ReservaViewHolder extends RecyclerView.ViewHolder {
        TextView tvTipo, tvCliente, tvFechas, tvCostoPorPersona;
        ImageView ivCamping;

        public ReservaViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTipo = itemView.findViewById(R.id.tvTipo);
            tvCliente = itemView.findViewById(R.id.tvCliente);
            tvFechas = itemView.findViewById(R.id.tvFechas);
            ivCamping = itemView.findViewById(R.id.ivCamping);
            tvCostoPorPersona = itemView.findViewById(R.id.tvCostoPorPersona);
        }
    }
}
