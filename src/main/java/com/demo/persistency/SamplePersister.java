package com.demo.persistency;

import com.demo.model.Employee;

import java.util.List;

public interface SamplePersister {

    List<Employee> getAllEmployees();

    void save(Employee employee);

    void saveNewTx(Employee employee);

    void update(Employee employee);

    void deleteNewTx(Employee employee);

    void delete(Employee employee);

    Employee get(int empId);

    Employee getNewTx(int empId);
}
