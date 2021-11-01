package com.demo.model;

public class Employee {
    private int databaseId;

    private String name;

    private String role;

    public int getDatabaseId() {
        return databaseId;
    }

    public void setDatabaseId(int databaseId) {
        this.databaseId = databaseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public Employee() {}
}
