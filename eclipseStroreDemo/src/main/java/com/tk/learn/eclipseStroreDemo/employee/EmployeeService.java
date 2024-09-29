package com.tk.learn.eclipseStroreDemo.employee;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepoInt employeeRepoInt;

    public EmployeeService(EmployeeRepoInt employeeRepoInt) {
        this.employeeRepoInt = employeeRepoInt;
    }

    public List<Employee> getAllEmployees() {
        return this.employeeRepoInt.findAll();
    }


    public Employee getEmployeeById(int id) {
        return this.employeeRepoInt.findById(id);
    }

    public Employee addEmployee(Employee employee) {
        return this.employeeRepoInt.save(employee);
    }

    public Employee updateEmployee(int id,Employee employee) {
        return this.employeeRepoInt.update(id, employee);
    }

    public void deleteEmployee(int id) {
        this.employeeRepoInt.deleteById(id);
    }


}
