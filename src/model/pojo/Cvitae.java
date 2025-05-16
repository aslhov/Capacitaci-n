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
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Conectando Paisaje
 */
@Entity
@Table(name = "cvitae")
public class Cvitae implements Serializable {
    
  @Id
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Trabajador trabajador;  
    
    
    
}
