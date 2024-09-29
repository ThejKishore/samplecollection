package com.tk.learn.demo.employee

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/employees")
class EmployeeRsc (val employeeService: EmployeeService){

    @GetMapping
    fun getEmployees() : List<Employee> = employeeService.findAll()

    @PostMapping
    fun saveEmployee(@RequestBody employee: Employee): Employee = employeeService.save(employee)

    @PutMapping("/{id}")
    fun saveEmployee(@PathVariable("id") employeeId:Long,@RequestBody employee: Employee,): Employee = employeeService.save(employee)



}