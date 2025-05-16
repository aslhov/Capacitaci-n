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
@Table(name = "modo_formacion")
public class Modo_formacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String m_form;

    public Modo_formacion() {
    }

    public Modo_formacion(String m_form) {
        this.m_form = m_form;
    }

    public Modo_formacion(long id, String m_form) {
        this.id = id;
        this.m_form = m_form;
    }

    public Modo_formacion(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getM_form() {
        return m_form;
    }

    public void setM_form(String m_form) {
        this.m_form = m_form;
    }
}
