package ir.maktab.employeeServlet.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Employee.class)
public abstract class Employee_ {

	public static volatile SingularAttribute<Employee, String> fatherName;
	public static volatile SingularAttribute<Employee, String> firstname;
	public static volatile SingularAttribute<Employee, String> nationalCode;
	public static volatile SingularAttribute<Employee, String> address;
	public static volatile SingularAttribute<Employee, Integer> id;
	public static volatile SingularAttribute<Employee, String> email;
	public static volatile SingularAttribute<Employee, String> lastname;

	public static final String FATHER_NAME = "fatherName";
	public static final String FIRSTNAME = "firstname";
	public static final String NATIONAL_CODE = "nationalCode";
	public static final String ADDRESS = "address";
	public static final String ID = "id";
	public static final String EMAIL = "email";
	public static final String LASTNAME = "lastname";

}

