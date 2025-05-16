/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author jenice
 */
@Entity
@Table(name = "capacitacion")
public class Capacitacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String acciones;
    private boolean cumplimiento;
    private String trimestre;
    private String tipo_Accion;
    private String mes_inicio;
    private int anyo_inicio;
    private String mes_fin;
    private int anyo_fin;

    @ManyToOne
    private Lugar lugar;

    @ManyToOne
    private Modo_formacion modo_formacion;

    @ManyToOne
    private Responsable responsable;

    public Capacitacion() {
    }

    public Capacitacion(long id) {
        this.id = id;
    }

    public Capacitacion(String acciones, boolean cumplimiento, String trimestre,
            String tipo_Accion, String mes_inicio, int anyo_inicio, String mes_fin,
            int anyo_fin, Lugar lugar, Modo_formacion modo_formacion, Responsable responsable) {
        this.acciones = acciones;
        this.cumplimiento = cumplimiento;
        this.trimestre = trimestre;
        this.tipo_Accion = tipo_Accion;
        this.mes_inicio = mes_inicio;
        this.anyo_inicio = anyo_inicio;
        this.mes_fin = mes_fin;
        this.anyo_fin = anyo_fin;
        this.lugar = lugar;
        this.modo_formacion = modo_formacion;
        this.responsable = responsable;
    }

    public Capacitacion(long id, String acciones, boolean cumplimiento,
            String trimestre, String tipo_Accion, String mes_inicio,
            int anyo_inicio, String mes_fin, int anyo_fin, Lugar lugar,
            Modo_formacion modo_formacion, Responsable responsable) {
        this.id = id;
        this.acciones = acciones;
        this.cumplimiento = cumplimiento;
        this.trimestre = trimestre;
        this.tipo_Accion = tipo_Accion;
        this.mes_inicio = mes_inicio;
        this.anyo_inicio = anyo_inicio;
        this.mes_fin = mes_fin;
        this.anyo_fin = anyo_fin;
        this.lugar = lugar;
        this.modo_formacion = modo_formacion;
        this.responsable = responsable;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAcciones() {
        return acciones;
    }

    public void setAcciones(String acciones) {
        this.acciones = acciones;
    }

    public boolean isCumplimiento() {
        return cumplimiento;
    }

    public void setCumplimiento(boolean cumplimiento) {
        this.cumplimiento = cumplimiento;
    }

    public String getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(String trimestre) {
        this.trimestre = trimestre;
    }

    public String getTipo_Accion() {
        return tipo_Accion;
    }

    public void setTipo_Accion(String tipo_Accion) {
        this.tipo_Accion = tipo_Accion;
    }

    public String getMes_inicio() {
        return mes_inicio;
    }

    public void setMes_inicio(String mes_inicio) {
        this.mes_inicio = mes_inicio;
    }

    public int getAnyo_inicio() {
        return anyo_inicio;
    }

    public void setAnyo_inicio(int anyo_inicio) {
        this.anyo_inicio = anyo_inicio;
    }

    public String getMes_fin() {
        return mes_fin;
    }

    public void setMes_fin(String mes_fin) {
        this.mes_fin = mes_fin;
    }

    public int getAnyo_fin() {
        return anyo_fin;
    }

    public void setAnyo_fin(int anyo_fin) {
        this.anyo_fin = anyo_fin;
    }

    public Lugar getLugar() {
        return lugar;
    }

    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
    }

    public Modo_formacion getModo_formacion() {
        return modo_formacion;
    }

    public void setModo_formacion(Modo_formacion modo_formacion) {
        this.modo_formacion = modo_formacion;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }

}
