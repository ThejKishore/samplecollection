package com.tk.learn.eclipseStroreDemo.employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRoot {
    private List<Employee> employees = new ArrayList<>();
    public List<Employee> getEmployees() {
        return employees;
    }
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
