/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.dao.*;
import model.pojo.*;

/**
 *
 * @author jenice
 */
public class pruba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//       CapacitacionDAO cdao = new CapacitacionDAO();
//       Lugar l = new Lugar("UNISS");
//       Modo_formacion mf = new Modo_formacion("Curso");
//       Responsable r = new Responsable("Yosbel");
//       Capacitacion c = new Capacitacion("eeeee", true, "1er trimestre", "Plan", "Mayo", 2020, "Mayo", 2020, l, mf, r);
//        cdao.getCapacitacion();

       TrabajadorDAO tdao = new TrabajadorDAO();
        System.out.println(tdao.getAllTrabajador());
        
    }
    
}
