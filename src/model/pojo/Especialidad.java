/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

/**
 *
 * @author Conectando Paisaje
 */
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Conectando Paisaje
 */
@Entity
@Table(name = "especialidad")
public class Especialidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nomb_especialidad;

    public Especialidad(String especialidad) {
        this.nomb_especialidad = especialidad;
    }

    public Especialidad() {
    }

    public Especialidad(long id) {
        this.id = id;
    }

    public Especialidad(long id, String nomb_especialidad) {
        this.id = id;
        this.nomb_especialidad = nomb_especialidad;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomb_especialidad() {
        return nomb_especialidad;
    }

    public void setNomb_especialidad(String nomb_especialidad) {
        this.nomb_especialidad = nomb_especialidad;
    }

}
