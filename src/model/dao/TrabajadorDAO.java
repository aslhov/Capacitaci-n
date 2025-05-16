/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.pojo.Trabajador;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author wason
 */
public class TrabajadorDAO extends DAO {
    
    public boolean AddTrabajador(Trabajador t) throws HibernateException {

        boolean flag;

        try {
            iniciaOperacion();
            getSession().save(t);
            flag = true;

        } catch (HibernateException he) {
            manejaExcepcion(he);
            flag = false;
        } finally {
            terminaOperacion();
        }
        return flag;

    }

    public boolean updateTrabajador(Trabajador t) throws HibernateException {
        boolean flag;

        try {
            iniciaOperacion();
            getSession().load(Trabajador.class, t.getId());
            getSession().update(t);
            flag = true;

        } catch (HibernateException he) {
            manejaExcepcion(he);
            flag = false;
        } finally {
            terminaOperacion();
        }
        return flag;

    }
    
    public List<Trabajador> getTrabajador() throws HibernateException {
        List<Trabajador> listNomb_Pueb = new ArrayList<>();
        try {
            iniciaOperacion();
            Query query = getSession().createQuery("FROM Trabajador order by grupo_id"); //group by grupo_nombregrupo");

            listNomb_Pueb = query.list();

        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            terminaOperacion();
        }
        return listNomb_Pueb;
    }
    
    public List<String> getAllTrabajador() throws HibernateException {
        List<String> list = new ArrayList<>();
        try {
            iniciaOperacion();
            Query query = getSession().createQuery("SELECT t.id, t.nombre, "
                    + "t.NroIdentidad, t.grupo.nombregrupo, t.cargo.cargo, "
                    + "t.especialidad.nomb_especialidad FROM Trabajador t"); //group by grupo_nombregrupo");

            list = query.list();

        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            terminaOperacion();
        }
        return list;
    }

    public List<Trabajador> getTrabajadorPorNombre(String nombre) throws HibernateException {
        List<Trabajador> listNomb_trab = new ArrayList<>();
        try {
            iniciaOperacion();
            Query query = getSession().createQuery("FROM Trabajador where LOWER(nombre) LIKE ?");
            query.setParameter(0, "%"+nombre+"%");
            listNomb_trab = query.list();

        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            terminaOperacion();
        }
        return listNomb_trab;
    }
    
    public List<Trabajador> getTrabajadorPorCI(String ci) throws HibernateException {
        List<Trabajador> list = new ArrayList<>();
        try {
            iniciaOperacion();
            Query query = getSession().createQuery("FROM Trabajador where LOWER(NroIdentidad) LIKE ?");
            query.setParameter(0, "%"+ci+"%");
            list = query.list();

        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            terminaOperacion();
        }
        return list;
    }
    
    public List<Trabajador> getTrabajadorPorID(String id) throws HibernateException {
        List<Trabajador> list = new ArrayList<>();
        try {
            iniciaOperacion();
            Query query = getSession().createQuery("FROM Trabajador where id=?");
            query.setParameter(0, id);
            list = query.list();

        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            terminaOperacion();
        }
        return list;
    }

    public List<String> getNombreTrabajador(String nomb_grupo) throws HibernateException {
        List<String> listNomb_Trab = new ArrayList<>();
        try {
            iniciaOperacion();
            Query query = getSession().createQuery("SELECT DISTINCT nombre FROM Trabajador t WHERE t.grupo.nombregrupo=?");
            query.setParameter(0, nomb_grupo);
            listNomb_Trab = query.list();

        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            terminaOperacion();
        }
        return listNomb_Trab;
    }

   public List<String> getNombreTrabajador() throws HibernateException {
        List<String> listNomb_Trab = new ArrayList<>();
        try {
            iniciaOperacion();
            Query query = getSession().createQuery("SELECT t.nombre FROM Trabajador t");
            listNomb_Trab = query.list();

        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            terminaOperacion();
        }
        return listNomb_Trab;
    } 

    public boolean deleteTrabajador(Trabajador t) throws HibernateException { //va a devolver las fechas pertenecientes a unas coordenadas

        boolean flag;

        try {
            iniciaOperacion();
            getSession().load(Trabajador.class, t.getId());
            getSession().delete(t);
            flag = true;

        } catch (HibernateException he) {
            manejaExcepcion(he);
            flag = false;
        } finally {
            terminaOperacion();
        }
        return flag;

    }
}
