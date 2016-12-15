package com.alumina.nikol.eul.Class;

import java.io.Serializable;

/**
 * Created by i7 on 15-12-16.
 */

public class Paquetes implements Serializable{
    String codigo,tamaño,fechaEnt,fechaLleg,observaciones;
    int estado;
    boolean fragil,express;

    public Paquetes() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public String getFechaEnt() {
        return fechaEnt;
    }

    public void setFechaEnt(String fechaEnt) {
        this.fechaEnt = fechaEnt;
    }

    public String getFechaLleg() {
        return fechaLleg;
    }

    public void setFechaLleg(String fechaLleg) {
        this.fechaLleg = fechaLleg;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public boolean isFragil() {
        return fragil;
    }

    public void setFragil(boolean fragil) {
        this.fragil = fragil;
    }

    public boolean isExpress() {
        return express;
    }

    public void setExpress(boolean express) {
        this.express = express;
    }
}
