package com.tk.learn.demo.employee

import org.springframework.stereotype.Service

@Service
class EmployeeService (val employeeRepo: EmployeeRepo){

    fun findAll(): List<Employee> = employeeRepo.findAll().toList()

    fun findById(id:Int) = employeeRepo.findById(id)

    fun save(employee: Employee) = employeeRepo.save(employee)


}