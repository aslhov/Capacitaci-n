/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.view;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

/**
 *
 * @author Conectando Paisaje
 */
public class Trabajador_CapacitacionView extends RecursiveTreeObject {

    private String idT;
    private long idC;
    private String nombre;
    private String grupo;
    private String acciones;
    private String mes_inicio;
    private int anyo_inicio;
    private String mes_fin;
    private int anyo_fin;
    private String tipo_Accion;
    private String trimestre;
    private String lugar;
    private String modo_formacion;
    private String responsable;
    private boolean cumplimiento;

    public Trabajador_CapacitacionView(String idT, long idC, String nombre,
            String grupo, String acciones, String mes_inicio, int anyo_inicio,
            String mes_fin, int anyo_fin, String tipo_Accion, String trimestre,
            String lugar, String modo_formacion, String responsable,
            boolean cumplimiento) {
        this.idT = idT;
        this.idC = idC;
        this.nombre = nombre;
        this.grupo = grupo;
        this.acciones = acciones;
        this.mes_inicio = mes_inicio;
        this.anyo_inicio = anyo_inicio;
        this.mes_fin = mes_fin;
        this.anyo_fin = anyo_fin;
        this.tipo_Accion = tipo_Accion;
        this.trimestre = trimestre;
        this.lugar = lugar;
        this.modo_formacion = modo_formacion;
        this.responsable = responsable;
        this.cumplimiento = cumplimiento;
    }

    public String getIdT() {
        return idT;
    }

    public void setIdT(String idT) {
        this.idT = idT;
    }

    public long getIdC() {
        return idC;
    }

    public void setIdC(long idC) {
        this.idC = idC;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getAcciones() {
        return acciones;
    }

    public void setAcciones(String acciones) {
        this.acciones = acciones;
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

    public String getTipo_Accion() {
        return tipo_Accion;
    }

    public void setTipo_Accion(String tipo_Accion) {
        this.tipo_Accion = tipo_Accion;
    }

    public String getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(String trimestre) {
        this.trimestre = trimestre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getModo_formacion() {
        return modo_formacion;
    }

    public void setModo_formacion(String modo_formacion) {
        this.modo_formacion = modo_formacion;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public boolean isCumplimiento() {
        return cumplimiento;
    }

    public void setCumplimiento(boolean cumplimiento) {
        this.cumplimiento = cumplimiento;
    }

}
