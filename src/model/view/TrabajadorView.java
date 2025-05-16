/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.view;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

/**
 *
 * @author wason
 */
public class TrabajadorView extends RecursiveTreeObject {

    private String id;
    private String nombre;
    private String NroIdentidad;
    private String grupo;
    private String cargo;
    private String direccion;
    private String especialidad;
    private String municipio;

    public TrabajadorView(String id, String nombre, String NroIdentidad,
            String grupo, String cargo, String direccion, String especialidad,
            String municipio) {
        this.id = id;
        this.nombre = nombre;
        this.NroIdentidad = NroIdentidad;
        this.grupo = grupo;
        this.cargo = cargo;
        this.direccion = direccion;
        this.especialidad = especialidad;
        this.municipio = municipio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNroIdentidad() {
        return NroIdentidad;
    }

    public void setNroIdentidad(String NroIdentidad) {
        this.NroIdentidad = NroIdentidad;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

}
