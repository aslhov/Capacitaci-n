/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import model.pojo.Capacitacion;
import model.pojo.Grupo;
import model.pojo.Lugar;
import model.pojo.Modo_formacion;
import model.pojo.Responsable;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author wason
 */
public class CapacitacionDAO extends DAO {

    public boolean AddCapacitacion(Capacitacion c) throws HibernateException {

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
    
    public List<Capacitacion> getCapacPorFecha(String mes_inicio, int anyo_inicio, String accion) throws HibernateException {
        List<Capacitacion> listCap = new ArrayList<>();
        try {
            iniciaOperacion();
            Query query = getSession().createQuery("FROM Capacitacion WHERE mes_inicio=? and anyo_inicio=? and acciones=?");
            query.setParameter(0, mes_inicio);
            query.setParameter(1, anyo_inicio);
            query.setParameter(2, accion);
            listCap = query.list();

        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            terminaOperacion();
        }
        return listCap;
    }

    public List<Capacitacion> getCapacPorDatos(String mes_inicio, int anyo_inicio, String accion, String lugar) throws HibernateException {
        List<Capacitacion> listCap = new ArrayList<>();
        try {
            iniciaOperacion();
            Query query = getSession().createQuery("FROM Capacitacion c WHERE c.mes_inicio=? and c.anyo_inicio=? and c.acciones=? and c.lugar.nombrelugar = ?");
            query.setParameter(0, mes_inicio);
            query.setParameter(1, anyo_inicio);
            query.setParameter(2, accion);
            query.setParameter(3, lugar);
            listCap = query.list();

        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            terminaOperacion();
        }
        return listCap;
    }
    
    public List<Integer> getAnyo() throws HibernateException {
        List<Integer> listanyo = new ArrayList<>();
        try {
            iniciaOperacion();
            Query query = getSession().createQuery("SELECT distinct c.anyo_inicio FROM Capacitacion c");
            listanyo = query.list();

        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            terminaOperacion();
        }
        return listanyo;
    }

    // acciones plan 
    public List<Long> getContAccionesplan(String trimestre, long m_form) throws HibernateException {
        List<Long> cant = new ArrayList<>();
        String p = "plan";
        trimestre = trimestre.toLowerCase();
        try {
            iniciaOperacion();
            Query query = getSession().createQuery("SELECT Count (Acciones) AS AccPlan FROM Capacitacion "
                    + "WHERE modo_formacion_id=? and Trimestre =? and tipo_accion =?");
           
            query.setParameter(0, m_form);
            query.setParameter(1, trimestre);            
            query.setParameter(2, p);
            cant = query.list();

        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            terminaOperacion();
        }
        return cant;
    }

    
      
    public List<Long> getContAcciones(int anyo, String m_form) throws HibernateException {
        List<Long> cant = new ArrayList<>();
        try {
            iniciaOperacion();
            Query query = getSession().createQuery("SELECT COUNT(distinct c.acciones) "
                    + "FROM Capacitacion c "
                    + "WHERE c.anyo_inicio=? and c.modo_formacion.m_form=?");
            query.setParameter(0, anyo);
            query.setParameter(1, m_form);
            cant = query.list();

        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            terminaOperacion();
        }
        return cant;
    }
    
    //ACCIONES REAL
    public List<Long> getContAccionesAll(String trimestre, long m_form) throws HibernateException {
        List<Long> cant = new ArrayList<>();
        
        boolean b = true;
        try {
            iniciaOperacion();
               Query query = getSession().createQuery("SELECT Count (Acciones) AS AccPlan FROM Capacitacion "
                    + "WHERE modo_formacion_id=? and Trimestre =? and cumplimiento=?");
            
            query.setParameter(0, m_form);
            query.setParameter(1, trimestre);           
            query.setParameter(2, b);
            cant = query.list();

        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            terminaOperacion();
        }
        return cant;
    }
    
    public List<Capacitacion> getCapacPorNombre(String nomb_accion) throws HibernateException {
        List<Capacitacion> listCap = new ArrayList<>();
        try {
            iniciaOperacion();
            Query query = getSession().createQuery("FROM Capacitacion WHERE acciones=?");
            query.setParameter(0, nomb_accion);
            listCap = query.list();

        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            terminaOperacion();
        }
        return listCap;
    }
    
    public List<Capacitacion> getAccion(String nomb_accion) throws HibernateException {
        List<Capacitacion> listCap = new ArrayList<>();
        try {
            iniciaOperacion();
            Query query = getSession().createQuery("FROM Capacitacion WHERE LOWER(acciones) LIKE ?");
            query.setParameter(0, "%"+nomb_accion+"%");
            listCap = query.list();

        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            terminaOperacion();
        }
        return listCap;
    }
    
    public List<Capacitacion> getModoFormacion(String m_formacion) throws HibernateException {
        List<Capacitacion> listCap = new ArrayList<>();
        try {
            iniciaOperacion();
            Query query = getSession().createQuery("FROM Capacitacion WHERE LOWER(modo_formacion.m_form) LIKE ?");
            query.setParameter(0, "%"+m_formacion+"%");
            listCap = query.list();

        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            terminaOperacion();
        }
        return listCap;
    }

    public List<Capacitacion> getCapacitacion() throws HibernateException {
        List<Capacitacion> listNomb_Pueb = new ArrayList<>();
        try {
            iniciaOperacion();
            Query query = getSession().createQuery("FROM Capacitacion");
//            query.setParameter(0, date);
//            query.setParameter(1, accion);
            listNomb_Pueb = query.list();

        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            terminaOperacion();
        }
        return listNomb_Pueb;
    }
    
    public List<Capacitacion> getCapacitacion(long id) throws HibernateException {
        List<Capacitacion> list = new ArrayList<>();
        try {
            iniciaOperacion();
            Query query = getSession().createQuery("FROM Capacitacion WHERE id = ?");
            query.setParameter(0, id);
//            query.setParameter(1, accion);
            list = query.list();

        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            terminaOperacion();
        }
        return list;
    }

    public void insertarCapacitacion(String acciones, boolean cumplimiento,String trimestre, String tipo_Accion, Date fInicio, Date fFinal,Lugar lugar, Modo_formacion modo_formacion, Responsable responsable) throws HibernateException {
//        List<Capacitacion> listNomb_Pueb = new ArrayList<>();
        try {
            iniciaOperacion();
            Query query = getSession().createQuery("INSERT INTO Capacitacion c "
                    + "(acciones, cumplimiento)");
//            query.setParameter(0, date);
//            query.setParameter(1, accion);

        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            terminaOperacion();
        }

    }

    public boolean eliminarCapacitacion(Capacitacion c) throws HibernateException {

        boolean flag;

        try {
            iniciaOperacion();
//           getSession().load(Fecha.class, f.getFecha()+f.getHorario());
            getSession().delete(c);
            flag = true;

        } catch (HibernateException he) {
            manejaExcepcion(he);
            flag = false;
        } finally {
            terminaOperacion();
        }
        return flag;

    }

    public boolean updateCapacitacion(Capacitacion c) throws HibernateException { 
        boolean flag;

        try {
            iniciaOperacion();
            getSession().load(Capacitacion.class, c.getId());
            getSession().update(c);
            flag = true;

        } catch (HibernateException he) {
            manejaExcepcion(he);
            flag = false;
        } finally {
            terminaOperacion();
        }
        return flag;

    }
    
    
     public List<String> getCapacitacionName() throws HibernateException {
        List<String> listNomb_Pueb = new ArrayList<>();
        try {
            iniciaOperacion();
            Query query = getSession().createQuery("SELECT acciones FROM Capacitacion");
//            query.setParameter(0, date);
//            query.setParameter(1, accion);
            listNomb_Pueb = query.list();

        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            terminaOperacion();
        }
        return listNomb_Pueb;
    }
    
     
     
     public Long getmdoForm(String m_form) throws HibernateException {
         List<Long> cant = new ArrayList<>();
         long idd = 0;
        try {
            iniciaOperacion();
            Query query = getSession().createQuery("SELECT id FROM Modo_formacion m "
                    + "WHERE m_form=? ");
            
            query.setParameter(0, m_form);
           
           cant = query.list();
           idd= cant.get(0);

        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            terminaOperacion();
        }
         
        return idd;
    }
    


   



   







}
