package com.tk.learn.eclipseStroreDemo.employee;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.val;
import org.eclipse.store.integrations.spring.boot.types.concurrent.Read;
import org.eclipse.store.integrations.spring.boot.types.concurrent.Write;
import org.eclipse.store.storage.embedded.types.EmbeddedStorageManager;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeRepo implements EmployeeRepoInt{

    private final EmbeddedStorageManager storageManager;

    public EmployeeRepo(EmbeddedStorageManager storageManager) {
        this.storageManager = storageManager;
    }

    @Read
    @Override
    public List<Employee> findAll() {
        EmployeeRoot root = (EmployeeRoot) this.storageManager.root();
        return new ArrayList<>(root.getEmployees());
    }

    @Read
    @Override
    public Employee findById(int id) {
        EmployeeRoot root = (EmployeeRoot) this.storageManager.root();
        return root.getEmployees().get(id);
    }

    @Write
    @Override
    public Employee save(Employee employee) {
        EmployeeRoot root = (EmployeeRoot) this.storageManager.root();
        val size = root.getEmployees().size();
        val employeeToStore = new Employee(size, employee.name(), employee.role());
        root.getEmployees().add(employeeToStore);
        this.storageManager.store(root.getEmployees());
        return employeeToStore;
    }

    @Write
    @Override
    public void deleteById(int id) {
        EmployeeRoot root = (EmployeeRoot) this.storageManager.root();
        root.getEmployees().remove(id);
        this.storageManager.store(root.getEmployees());
    }

    @Write
    @Override
    public Employee update(int id, Employee employee) {
        EmployeeRoot root = (EmployeeRoot) this.storageManager.root();
        root.getEmployees().add(id,employee);
        this.storageManager.store(root.getEmployees());
        return employee;
    }
}
