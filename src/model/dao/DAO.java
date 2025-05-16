package model.dao;

import Util.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Jorge
 */
public abstract class DAO {
    Session sesion;

    protected void iniciaOperacion()
    {
        sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.getTransaction().begin();
    }

    protected void terminaOperacion()
    {
        sesion.getTransaction().commit();
        sesion.close();
    }

    protected void manejaExcepcion(HibernateException he) throws HibernateException
    {
        sesion.getTransaction().rollback();
        throw he;
    }

    protected Session getSession()
    {
        return sesion;
    }

    public static void almacenaEntidad(Object entidad) throws HibernateException
    {
        DAO dao = new DAO(){};

        try
        {
            dao.iniciaOperacion();
            dao.getSession().saveOrUpdate(entidad);
            dao.getSession().flush();
        }
        catch (HibernateException he)
        {
            dao.manejaExcepcion(he);
        }
        finally
        {
            dao.terminaOperacion();
        }
    }
    public static void almacenaEntidadPersist(Object entidad) throws HibernateException
    {
        DAO dao = new DAO(){};

        try
        {
            dao.iniciaOperacion();
            dao.getSession().persist(entidad);
            dao.getSession().flush();
        }
        catch (HibernateException he)
        {
            dao.manejaExcepcion(he);
        }
        finally
        {
            dao.terminaOperacion();
        }
    }

    public static <T> T getEntidad(Serializable id, Class<T> claseEntidad) throws HibernateException
    {
        DAO dao = new DAO(){};

        T objetoRecuperado = null;

        try
        {
            dao.iniciaOperacion();
            objetoRecuperado = (T) dao.getSession().get(claseEntidad, id);
        }
        catch (HibernateException he)
        {
            dao.manejaExcepcion(he);
        }
        finally
        {
            dao.terminaOperacion();
        }

        return objetoRecuperado;
    }

    public static <T> List<T> getListaEntidades(Class<T> claseEntidad) throws HibernateException
    {
        DAO dao = new DAO(){};

        List<T> listaResultado = null;

        try
        {
            dao.iniciaOperacion();
            listaResultado = dao.getSession().createQuery("FROM " + claseEntidad.getSimpleName()).list();
        }
        catch (HibernateException he)
        {
            dao.manejaExcepcion(he);
        }
        finally
        {
            dao.terminaOperacion();
        }

        return listaResultado;
    }    
    
}
