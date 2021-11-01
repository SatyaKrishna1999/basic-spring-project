package com.demo.persistency.impl;

import com.demo.model.Employee;
import com.demo.persistency.SamplePersister;
import com.demo.transformers.EmployeeResultTransformer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class SamplePersisterImpl implements SamplePersister {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     *
     * @return
     */

    @Override
    public List<Employee> getAllEmployees() {
        Query<Employee> query = getSession().createQuery("select emp from Employee emp", Employee.class);
        System.out.println("Satya");
        return query.getResultList();
    }

    public void save(Employee employee) {
        getSession().save(employee);
    }

    @Override
    public void saveNewTx(Employee employee) {
        this.save(employee);
    }

    @Override
    public void update(Employee employee) {
        getSession().update(employee);
    }

    @Override
    public void deleteNewTx(Employee employee) {
        this.delete(employee);
    }

    @Override
    public void delete(Employee employee) {
        getSession().delete(employee);
    }

    @Override
    public Employee get(int empId) {
        return getSession().find(Employee.class, empId);
    }

    @Override
    public Employee getNewTx(int empId) {
        return this.get(empId);
    }
}
