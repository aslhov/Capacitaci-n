/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.pojo.*;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author wason
 */
public class ResponsableDAO extends DAO{

    public boolean addResponsable(Responsable r) throws HibernateException {
        boolean flag;

        try {
            iniciaOperacion();
            getSession().save(r);
            flag = true;

        } catch (HibernateException he) {
            manejaExcepcion(he);
            flag = false;
        } finally {
            terminaOperacion();
        }
        return flag;

    }
    
    public List<Responsable> getNombreResponsable(String nombre) throws HibernateException {
        List<Responsable> listNomb = new ArrayList<>();
        try {
            iniciaOperacion();
            Query query = getSession().createQuery("FROM Responsable where nomb_responsable=?");
            query.setParameter(0, nombre);
            listNomb = query.list();

        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            terminaOperacion();
        }
        return listNomb;
    }
    
    public List<String> getNombreResponsable() throws HibernateException {
        List<String> listNomb = new ArrayList<>();
        try {
            iniciaOperacion();
            Query query = getSession().createQuery("SELECT nomb_responsable FROM Responsable");
//            query.setParameter(0, nombre);
            listNomb = query.list();

        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            terminaOperacion();
        }
        return listNomb;
    }
}
