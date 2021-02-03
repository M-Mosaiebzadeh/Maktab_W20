package ir.maktab.employeeServlet.services;

import ir.maktab.employeeServlet.dao.EmployeeDao;
import ir.maktab.employeeServlet.entities.Employee;
import static ir.maktab.employeeServlet.util.EntityManagerFactoryUtil.*;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    private static EntityManager entityManager;
    private static EmployeeDao employeeDao;

    public static void save(Employee employee) {
        entityManager = createEntityManagerFactory().createEntityManager();
        employeeDao = new EmployeeDao(entityManager);
        entityManager.getTransaction().begin();
        employeeDao.save(employee);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static List<Employee> findEmployee(String firstname,String lastname,String email) {
        entityManager = createEntityManagerFactory().createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
        Root<Employee> fromEmployee = query.from(Employee.class);

        query.select(fromEmployee).where(builder.and(
                builder.like(fromEmployee.get("firstname"),"%" + firstname + "%"),
                builder.and(
                        builder.like(fromEmployee.get("lastname"),"%" + lastname + "%"),
                        builder.like(fromEmployee.get("email"),"%" + email + "%")
                )
        ));


//        List<Predicate> predicateList = new ArrayList<>();
//        predicateList.add(builder.like(fromEmployee.get("firstname"),"%" + firstname + "%"));
//        predicateList.add(builder.like(fromEmployee.get("lastname"),"%" + lastname + "%"));
//        predicateList.add(builder.like(fromEmployee.get("email"),"%" + email + "%"));
//
//        Predicate predicate = builder.and(predicateList.toArray(new Predicate[0]));
//        query.select(fromEmployee).where(predicate);
//
        TypedQuery<Employee> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList();
    }

    public static List<Employee> isExist(String email) {
        entityManager = createEntityManagerFactory().createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
        Root<Employee> fromEmployee = query.from(Employee.class);

        query.select(fromEmployee).where(builder.equal(fromEmployee.get("email"),email));

        TypedQuery<Employee> typedQuery = entityManager.createQuery(query);

         return typedQuery.getResultList();
    }

    public static void update(Employee employee) {
        entityManager = createEntityManagerFactory().createEntityManager();
        employeeDao = new EmployeeDao(entityManager);
        entityManager.getTransaction().begin();
        employeeDao.update(employee);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static void delete(Employee employee) {
        entityManager = createEntityManagerFactory().createEntityManager();
        employeeDao = new EmployeeDao(entityManager);
        entityManager.getTransaction().begin();
        employeeDao.delete(entityManager.contains(employee)?employee:entityManager.merge(employee));
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static Employee loadById(Integer id) {
        entityManager = createEntityManagerFactory().createEntityManager();
        employeeDao = new EmployeeDao(entityManager);
        Employee employee = employeeDao.load(id);
        entityManager.close();
        return employee;
    }

    public static List<Employee> loadAll() {
        entityManager = createEntityManagerFactory().createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
        Root<Employee> fromEmployee = query.from(Employee.class);

        query.select(fromEmployee);

        TypedQuery<Employee> typedQuery = entityManager.createQuery(query);

        return typedQuery.getResultList();
    }
}
