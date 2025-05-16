/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author wason
 */
@Entity
@Table(name = "responsable")
public class Responsable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nomb_responsable;

    public Responsable() {
    }

    public Responsable(String nomb_responsable) {
        this.nomb_responsable = nomb_responsable;
    }

    public Responsable(long id) {
        this.id = id;
    }

    public Responsable(long id, String nomb_responsable) {
        this.id = id;
        this.nomb_responsable = nomb_responsable;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomb_responsable() {
        return nomb_responsable;
    }

    public void setNomb_responsable(String nomb_responsable) {
        this.nomb_responsable = nomb_responsable;
    }
}
