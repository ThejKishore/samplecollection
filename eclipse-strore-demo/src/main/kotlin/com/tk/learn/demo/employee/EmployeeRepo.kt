package com.tk.learn.demo.employee

import software.xdev.spring.data.eclipse.store.repository.interfaces.EclipseStoreCrudRepository

interface EmployeeRepo : EclipseStoreCrudRepository<Employee,Int> {
}