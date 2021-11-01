package com.demo.transformers;

import com.demo.model.Employee;
import org.hibernate.transform.ResultTransformer;

import java.util.List;

public class EmployeeResultTransformer implements ResultTransformer {
    @Override
    public Object transformTuple(Object[] objects, String[] strings) {
        Employee emp = new Employee();
        emp.setDatabaseId((int) objects[0]);
        emp.setRole((String) objects[1]);
        return emp;
    }

    @Override
    public List transformList(List list) {
        return list;
    }
}
