package com.example.gestiondehospedaje.Activities;

import java.util.List;

public class ReservaCamping extends Reserva {
    private int metrosCuadrados;
    private boolean tieneElectricidad;
    private int numeroPersonas;
    private int costoPorPersona;
    private String img;
    private String tipoCamping;
    private List<String> actividades;

    public ReservaCamping(String id, String cliente, String fechaEntrada, String fechaSalida,
                          double precio, int metrosCuadrados, boolean tieneElectricidad,
                          int numeroPersonas, int costoPorPersona, List<String> actividades, int camping) {
        super(id, cliente, fechaEntrada, fechaSalida, precio);
        this.metrosCuadrados = metrosCuadrados;
        this.tieneElectricidad = tieneElectricidad;
        this.numeroPersonas = numeroPersonas;
        this.tipoCamping = tipoCamping;
        this.actividades = actividades;
        this.costoPorPersona = costoPorPersona;
        this.img = img;
    }

    @Override
    public String getTipo() {
        return "camping";
    }

    public int getMetrosCuadrados() {
        return metrosCuadrados;
    }

    public boolean isTieneElectricidad() {
        return tieneElectricidad;
    }

    public int getNumeroPersonas() {
        return numeroPersonas;
    }

    public String getTipoCamping() {
        return tipoCamping;
    }

    public List<String> getActividades() {
        return actividades;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getCostoPorPersona() {
        return costoPorPersona;
    }

    public void setCostoPorPersona(int costoPorPersona) {
        this.costoPorPersona = costoPorPersona;
    }
}