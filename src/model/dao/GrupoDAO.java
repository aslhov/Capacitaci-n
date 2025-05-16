package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.pojo.Grupo;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author wason
 */
public class GrupoDAO extends DAO {

    public boolean addGrupo(Grupo g) throws HibernateException {
        boolean flag;

        try {
            iniciaOperacion();
            getSession().save(g);
            flag = true;

        } catch (HibernateException he) {
            manejaExcepcion(he);
            flag = false;
        } finally {
            terminaOperacion();
        }
        return flag;

    }

    public List<Grupo> getNombreGrupo(String nombre) throws HibernateException {
        List<Grupo> listNomb = new ArrayList<>();
        try {
            iniciaOperacion();
            Query query = getSession().createQuery("FROM Grupo g where g.nombregrupo=?");
            query.setParameter(0, nombre);
            listNomb = query.list();

        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            terminaOperacion();
        }
        return listNomb;
    }

    public List<String> getGrupoNombre() throws HibernateException {
        List<String> listNomb = new ArrayList<>();
        try {
            iniciaOperacion();
            Query query = getSession().createQuery("SELECT nombregrupo FROM Grupo");
//            query.setParameter(0, nombre);
            listNomb = query.list();

        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            terminaOperacion();
        }
        return listNomb;
    }

    public boolean updateGrupo(Grupo g) throws HibernateException {
        boolean flag;

        try {
            iniciaOperacion();
            getSession().load(Grupo.class, g.getNombregrupo());
            getSession().update(g);
            flag = true;

        } catch (HibernateException he) {
            manejaExcepcion(he);
            flag = false;
        } finally {
            terminaOperacion();
        }
        return flag;

    }

    public boolean deleteGrupo(Grupo g) throws HibernateException {

        boolean flag;

        try {
            iniciaOperacion();
            getSession().delete(g);
            flag = true;

        } catch (HibernateException he) {
            manejaExcepcion(he);
            flag = false;
        } finally {
            terminaOperacion();
        }
        return flag;

    }

    public List<Long> getGrupoid(String nombre) throws HibernateException {
        List<Long> listNomb = new ArrayList<>();;
        try {
            iniciaOperacion();
            Query query = getSession().createQuery("SELECT id FROM Grupo WHERE nombregrupo=?");
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
