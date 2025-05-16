/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author jenice
 */
@Entity
@Table(name = "trabajador")
public class Trabajador implements Serializable {

    @Id
    private String id;

    @Column(nullable = false)
    private String nombre;

    @ManyToOne
    private Grupo grupo;

    @Column(nullable = false)
    private String NroIdentidad;

    @Column(nullable = true)
    private String direccion;

    @Column(nullable = true)
    private String municipio;

    @ManyToOne
    private Cargo cargo;

    @ManyToOne
    private Especialidad especialidad;

    public Trabajador() {
    }

    public Trabajador(String nombre) {
        this.nombre = nombre;
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

    public Trabajador(String id, String nombre, Grupo grupo, String NroIdentidad, String direccion,
            String municipio, Cargo cargo, Especialidad especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.grupo = grupo;
        this.NroIdentidad = NroIdentidad;
        this.direccion = direccion;
        this.municipio = municipio;
        this.cargo = cargo;
        this.especialidad = especialidad;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public String getNroIdentidad() {
        return NroIdentidad;
    }

    public void setNroIdentidad(String NroIdentidad) {
        this.NroIdentidad = NroIdentidad;
    }

    public String getdireccion() {
        return direccion;
    }

    public void setdireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getmunicipio() {
        return municipio;
    }

    public void setmunicipio(String municipio) {
        this.municipio = municipio;
    }

    public Cargo getcargo() {
        return cargo;
    }

    public void setcargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

}
