package ir.maktab.employeeServlet.dao;

import ir.maktab.employeeServlet.entities.Employee;

import javax.persistence.EntityManager;

public class EmployeeDao {
    EntityManager entityManager;

    public EmployeeDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Employee employee) {
        entityManager.persist(employee);
    }

    public Employee load(Integer id) {
        return entityManager.find(Employee.class,id);
    }

    public void delete(Employee employee) {
        entityManager.remove(employee);
    }

    public void update(Employee employee) {
        entityManager.merge(employee);
    }
}
