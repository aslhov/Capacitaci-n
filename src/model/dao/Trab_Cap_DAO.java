/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import Util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.pojo.*;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import model.dao.*;

/**
 *
 * @author jenice
 */
public class Trab_Cap_DAO extends DAO {

    private final TrabajadorDAO tdao = new TrabajadorDAO();
    private final CapacitacionDAO cdao = new CapacitacionDAO();

    public List<Trabajador_Capacitacion> getCapacitacionPorTrabajador(Trabajador t, Capacitacion c) throws HibernateException {
        List<Trabajador_Capacitacion> listtrab = new ArrayList<>();
        try {
            iniciaOperacion();
            Query query = getSession().createQuery("FROM Trabajador_Capacitacion WHERE trabajador.id =? "
                    + "and capacitacion.acciones=? and capacitacion.mes_inicio=? and capacitacion.anyo_inicio=?");
            query.setParameter(0, t.getId());
            query.setParameter(1, c.getAcciones());
            query.setParameter(2, c.getMes_inicio());
            query.setParameter(3, c.getAnyo_inicio());
            listtrab = query.list();

        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            terminaOperacion();
        }
        return listtrab;
    }

    public List<Trabajador_Capacitacion> getCapacitacionTrabajadorxId(String idT, long idC) throws HibernateException {
        List<Trabajador_Capacitacion> listtrab = new ArrayList<>();
        try {
            iniciaOperacion();
            Query query = getSession().createQuery("FROM Trabajador_Capacitacion WHERE trabajador.id =? "
                    + "and capacitacion.id=?");
            query.setParameter(0, idT);
            query.setParameter(1, idC);
            listtrab = query.list();

        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            terminaOperacion();
        }
        return listtrab;
    }

    //GRADUADOS PLAN
    public List<Long> getContTrabajador(String trimestre, String m_form) throws HibernateException {
        List<Long> cant = new ArrayList<>();
        try {
            iniciaOperacion();
            Query query = getSession().createQuery("SELECT COUNT(distinct tc.trabajador.nombre) "
                    + "FROM Trabajador_Capacitacion tc "
                    + "WHERE tc.capacitacion.trimestre=? and tc.capacitacion.modo_formacion.m_form=?");
            query.setParameter(0, trimestre);
            query.setParameter(1, m_form);
            cant = query.list();

        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            terminaOperacion();
        }
        return cant;
    }
    public boolean eliminarTrabCap(Trabajador_Capacitacion tc) throws HibernateException {

        boolean flag;

        try {
            iniciaOperacion();
//           getSession().load(Fecha.class, f.getFecha()+f.getHorario());
            getSession().delete(tc);
            flag = true;

        } catch (HibernateException he) {
            manejaExcepcion(he);
            flag = false;
        } finally {
            terminaOperacion();
        }
        return flag;

    }

    public List<Long> getContTrabajador(int anyo, String m_form) throws HibernateException {
        List<Long> cant = new ArrayList<>();
        try {
            iniciaOperacion();
            Query query = getSession().createQuery("SELECT COUNT(distinct tc.trabajador.nombre) "
                    + "FROM Trabajador_Capacitacion tc "
                    + "WHERE tc.capacitacion.anyo_inicio=? and tc.capacitacion.modo_formacion.m_form=?");
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

    //GRADUADOS REAL
    public List<Long> getContTrabCumpl(String trimestre, String m_form) throws HibernateException {
        List<Long> cant = new ArrayList<>();
        try {
            iniciaOperacion();
            Query query = getSession().createQuery("SELECT COUNT(distinct tc.trabajador.nombre) "
                    + "FROM Trabajador_Capacitacion tc "
                    + "WHERE tc.capacitacion.trimestre=? and tc.capacitacion.modo_formacion.m_form=?"
                    + "and tc.capacitacion.cumplimiento='true'");
            query.setParameter(0, trimestre);
            query.setParameter(1, m_form);
            cant = query.list();

        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            terminaOperacion();
        }
        return cant;
    }

    public List<Long> getContTrabCumpl(int anyo, String m_form) throws HibernateException {
        List<Long> cant = new ArrayList<>();
        try {
            iniciaOperacion();
            Query query = getSession().createQuery("SELECT COUNT(distinct tc.trabajador.nombre) "
                    + "FROM Trabajador_Capacitacion tc "
                    + "WHERE tc.capacitacion.anyo_inicio=? and tc.capacitacion.modo_formacion.m_form=?"
                    + "and tc.capacitacion.cumplimiento='true'");
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

    public List<Trabajador_Capacitacion> getALLCapacitacionxTrabajador() throws HibernateException {
        List<Trabajador_Capacitacion> listtrab = new ArrayList<>();
        try {
            iniciaOperacion();
            Query query = getSession().createQuery("FROM Trabajador_Capacitacion");

            listtrab = query.list();

        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            terminaOperacion();
        }
        return listtrab;
    }

    public List<Trabajador_Capacitacion> getNombreTrabajador(String nombre) throws HibernateException {
        List<Trabajador_Capacitacion> listtrab = new ArrayList<>();
        try {
            iniciaOperacion();
            Query query = getSession().createQuery("FROM Trabajador_Capacitacion tc WHERE LOWER(tc.trabajador.nombre) LIKE ?");
            query.setParameter(0, "%" + nombre + "%");
            listtrab = query.list();

        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            terminaOperacion();
        }
        return listtrab;
    }

    public List<Trabajador_Capacitacion> getAccion(String accion) throws HibernateException {
        List<Trabajador_Capacitacion> listtrab = new ArrayList<>();
        try {
            iniciaOperacion();
            Query query = getSession().createQuery("FROM Trabajador_Capacitacion tc WHERE LOWER(tc.capacitacion.acciones) LIKE ?");
            query.setParameter(0, "%" + accion + "%");
            listtrab = query.list();

        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            terminaOperacion();
        }
        return listtrab;
    }

    public boolean insertar(String nomb_pers, String acciones) {
        boolean flag = false;
        Trabajador t = tdao.getTrabajadorPorNombre(nomb_pers).get(0);
        Capacitacion c = new Capacitacion();
        c = cdao.getCapacPorNombre(acciones).get(0);

        if (!getCapacitacionPorTrabajador(t, c).isEmpty()) {
            JOptionPane.showMessageDialog(null, "El trabajador ya existe con esa acción");

        } else {
            try {
                Trabajador_Capacitacion tc = new Trabajador_Capacitacion(c, t);

                Session sesion = HibernateUtil.getSessionFactory().openSession();
                sesion.beginTransaction();
                sesion.save(tc);
                sesion.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Datos guardados correctamente.");
                flag = true;
                sesion.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al guardar.");
            }

        }

        return flag;
    }

}
