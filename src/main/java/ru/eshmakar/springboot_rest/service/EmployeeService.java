package ru.eshmakar.springboot_rest.service;

import ru.eshmakar.springboot_rest.entity.Employee;

import java.util.List;
public interface EmployeeService {
    List<Employee> getAllEmployees();
//    void saveEmployee(Employee employee);
//    Employee getEmployee(int id);
//
//    void deleteEmployee(int id);
}
