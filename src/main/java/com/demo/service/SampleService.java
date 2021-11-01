package com.demo.service;

import com.demo.model.Employee;

import java.util.List;

public interface SampleService {
    List<Employee> getAllEmployees() throws Exception;

    void save(Employee employee);

    void saveNewTx(Employee employee);
}
