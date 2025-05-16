/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.pojo.Cargo;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author Conectando Paisaje
 */
public class CargoDAO extends DAO {
    
    public boolean addCargo(Cargo c) throws HibernateException {
        boolean flag;

        try {
            iniciaOperacion();
            getSession().save(c);
            flag = true;

        } catch (HibernateException he) {
            manejaExcepcion(he);
            flag = false;
        } finally {
            terminaOperacion();
        }
        return flag;

    }

    public List<Cargo> getNombreCargo(String nombre) throws HibernateException {
        List<Cargo> listNomb = new ArrayList<>();
        try {
            iniciaOperacion();
            Query query = getSession().createQuery("FROM Cargo c WHERE c.cargo=?");
            query.setParameter(0, nombre);
            listNomb = query.list();

        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            terminaOperacion();
        }
        return listNomb;
    }

    public List<String> getCargoNombre() throws HibernateException {
        List<String> listNomb = new ArrayList<>();
        try {
            iniciaOperacion();
            Query query = getSession().createQuery("SELECT cargo FROM Cargo");
//           query.setParameter(0, nombre);
            listNomb = query.list();

        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            terminaOperacion();
        }
        return listNomb;
    }
    
    
    
    public List<Long> getCargoid (String nombre) throws HibernateException {
        List<Long> listNomb = new ArrayList<>(); ;
        try {
            iniciaOperacion();
            Query query = getSession().createQuery("SELECT id FROM Cargo  WHERE cargo=?");
            query.setParameter(0, nombre);
            listNomb = query.list();

        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            terminaOperacion();
        }
        return listNomb;
    }
    
    
    
    
    
    
    
    
}

