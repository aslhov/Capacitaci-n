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
public class Modo_formacionDAO extends DAO {

    public boolean addModo_formacion(Modo_formacion md) throws HibernateException {
        boolean flag;

        try {
            iniciaOperacion();
            getSession().save(md);
            flag = true;

        } catch (HibernateException he) {
            manejaExcepcion(he);
            flag = false;
        } finally {
            terminaOperacion();
        }
        return flag;

    }
    
    public List<Modo_formacion> getNombreModo_formacion(String nombre) throws HibernateException {
        List<Modo_formacion> listNomb = new ArrayList<>();
        try {
            iniciaOperacion();
            Query query = getSession().createQuery("FROM Modo_formacion where m_form=?");
            query.setParameter(0, nombre);
            listNomb = query.list();

        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            terminaOperacion();
        }
        return listNomb;
    }
    
    public List<String> getModo_formacion() throws HibernateException {
        List<String> listNomb = new ArrayList<>();
        try {
            iniciaOperacion();
            Query query = getSession().createQuery("SELECT m_form FROM Modo_formacion");
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
