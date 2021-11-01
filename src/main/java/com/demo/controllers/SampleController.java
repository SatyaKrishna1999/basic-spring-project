package com.demo.controllers;

import com.demo.model.Employee;
import com.demo.service.SampleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class SampleController {

    @Resource(name = "b2bSampleService")
    private SampleService sampleService;

    @GetMapping("/employee")
    public List<Employee> getAllEmployees() throws Exception {
        return sampleService.getAllEmployees();
    }
}
