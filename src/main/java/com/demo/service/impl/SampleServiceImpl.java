package com.demo.service.impl;

import com.demo.model.Employee;
import com.demo.persistency.SamplePersister;
import com.demo.service.SampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SampleServiceImpl implements SampleService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SampleServiceImpl.class);

    private SamplePersister samplePersister;

    public void setSamplePersister(SamplePersister samplePersister) {
        this.samplePersister = samplePersister;
    }

    @Override
    public List<Employee> getAllEmployees() throws Exception {
        List<Employee> employees = samplePersister.getAllEmployees();

        Employee satya = new Employee("Associate", "Satya");
        Employee madhu = new Employee("Manager", "Madhu");
        Employee jagan = new Employee("Senior Manager", "Jagan");

        this.saveNewTx(satya);
        samplePersister.save(madhu);
        samplePersister.save(jagan);

        System.out.println(samplePersister.get(satya.getDatabaseId()) == null);
        System.out.println(samplePersister.getNewTx(madhu.getDatabaseId()) == null);
        // delete entites

        samplePersister.deleteNewTx(satya);
        samplePersister.delete(madhu);
//        samplePersister.delete(jagan);

        return employees;
    }

    @Override
    public void save(Employee employee) {
        samplePersister.save(employee);
    }

    @Override
    public void saveNewTx(Employee employee) {
        this.save(employee);
    }
}
