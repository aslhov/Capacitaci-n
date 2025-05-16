package model.pojo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Capacitacion.class)
public abstract class Capacitacion_ {

	public static volatile SingularAttribute<Capacitacion, Modo_formacion> modo_formacion;
	public static volatile SingularAttribute<Capacitacion, Boolean> cumplimiento;
	public static volatile SingularAttribute<Capacitacion, String> mes_inicio;
	public static volatile SingularAttribute<Capacitacion, String> tipo_Accion;
	public static volatile SingularAttribute<Capacitacion, String> acciones;
	public static volatile SingularAttribute<Capacitacion, Responsable> responsable;
	public static volatile SingularAttribute<Capacitacion, String> mes_fin;
	public static volatile SingularAttribute<Capacitacion, Lugar> lugar;
	public static volatile SingularAttribute<Capacitacion, Long> id;
	public static volatile SingularAttribute<Capacitacion, String> trimestre;
	public static volatile SingularAttribute<Capacitacion, Integer> anyo_inicio;
	public static volatile SingularAttribute<Capacitacion, Integer> anyo_fin;

}

