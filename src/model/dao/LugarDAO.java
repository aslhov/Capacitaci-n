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
public class LugarDAO extends DAO{
    
    public boolean addLugar(Lugar l) throws HibernateException {
        boolean flag;

        try {
            iniciaOperacion();
            getSession().save(l);
            flag = true;

        } catch (HibernateException he) {
            manejaExcepcion(he);
            flag = false;
        } finally {
            terminaOperacion();
        }
        return flag;

    }

    public List<Lugar> getNombreLugar(String nombre) throws HibernateException {
        List<Lugar> listNomb = new ArrayList<>();
        try {
            iniciaOperacion();
            Query query = getSession().createQuery("FROM Lugar where nombrelugar=?");
            query.setParameter(0, nombre);
            listNomb = query.list();

        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            terminaOperacion();
        }
        return listNomb;
    }
    
    public List<String> getLugar() throws HibernateException {
        List<String> listNomb = new ArrayList<>();
        try {
            iniciaOperacion();
            Query query = getSession().createQuery("SELECT nombrelugar FROM Lugar");
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
