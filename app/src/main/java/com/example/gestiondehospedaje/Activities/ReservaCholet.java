package com.example.gestiondehospedaje.Activities;

public class ReservaCholet extends Reserva {
    private int metrosCuadrados;
    private boolean tieneJardin;
    private int numeroHabitaciones;

    public ReservaCholet(String id, String cliente, String fechaEntrada, String fechaSalida,
                        double precio, int metrosCuadrados, boolean tieneJardin, int numeroHabitaciones) {
        super(id, cliente, fechaEntrada, fechaSalida, precio);
        this.metrosCuadrados = metrosCuadrados;
        this.tieneJardin = tieneJardin;
        this.numeroHabitaciones = numeroHabitaciones;
    }

    @Override
    public String getTipo() {
        return "cholet";
    }

    public int getMetrosCuadrados() {
        return metrosCuadrados;
    }

    public boolean isTieneJardin() {
        return tieneJardin;
    }

    public int getNumeroHabitaciones() {
        return numeroHabitaciones;
    }
} 