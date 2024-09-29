package com.tk.learn.eclipseStroreDemo.employee;

import java.util.List;

public interface EmployeeRepoInt {
    public List<Employee> findAll();
    public Employee findById(int id);
    public Employee save(Employee employee);
    public void deleteById(int id);
    public Employee update(int id,Employee employee);
}
