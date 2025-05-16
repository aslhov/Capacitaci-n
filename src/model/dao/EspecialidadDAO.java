/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.pojo.Especialidad;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author Conectando Paisaje
 */
public class EspecialidadDAO extends DAO {

    public boolean addEspecialidad(Especialidad e) throws HibernateException {
        boolean flag;

        try {
            iniciaOperacion();
            getSession().save(e);
            flag = true;

        } catch (HibernateException he) {
            manejaExcepcion(he);
            flag = false;
        } finally {
            terminaOperacion();
        }
        return flag;

    }

    public List<Especialidad> getNombreEspecialidad(String nombre) throws HibernateException {
        List<Especialidad> listNomb = new ArrayList<>();
        try {
            iniciaOperacion();
            Query query = getSession().createQuery("FROM Especialidad e where e.nomb_especialidad=?");
            query.setParameter(0, nombre);
            listNomb = query.list();

        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            terminaOperacion();
        }
        return listNomb;
    }

    public List<String> getEspecialidadNombre() throws HibernateException {
        List<String> listNomb = new ArrayList<>();
        try {
            iniciaOperacion();
            Query query = getSession().createQuery("SELECT nomb_especialidad FROM Especialidad");
//            query.setParameter(0, nombre);
            // query.setParameter
            listNomb = query.list();

        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            terminaOperacion();
        }
        return listNomb;
    }

    public List<Long> getEspecialidadid(String nombre) throws HibernateException {
        List<Long> listNomb = new ArrayList<>();;
        try {
            iniciaOperacion();
            Query query = getSession().createQuery("SELECT id FROM Especialidad  WHERE nomb_especialidad=?");
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
