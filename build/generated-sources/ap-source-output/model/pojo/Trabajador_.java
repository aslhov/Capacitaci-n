package model.pojo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Trabajador.class)
public abstract class Trabajador_ {

	public static volatile SingularAttribute<Trabajador, String> NroIdentidad;
	public static volatile SingularAttribute<Trabajador, String> municipio;
	public static volatile SingularAttribute<Trabajador, Grupo> grupo;
	public static volatile SingularAttribute<Trabajador, String> direccion;
	public static volatile SingularAttribute<Trabajador, String> id;
	public static volatile SingularAttribute<Trabajador, Cargo> cargo;
	public static volatile SingularAttribute<Trabajador, String> nombre;
	public static volatile SingularAttribute<Trabajador, Especialidad> especialidad;

}

