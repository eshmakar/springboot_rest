package ru.eshmakar.springboot_rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.eshmakar.springboot_rest.dao.EmployeeDAO;
import ru.eshmakar.springboot_rest.entity.Employee;

import java.util.List;

@Service // является посредником между Controller и DAO
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired//получаем бин
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional //для открытия и закрытия транзакции
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

//    @Override
//    @Transactional
//    public void saveEmployee(Employee employee) {
//        employeeDAO.saveEmployee(employee);
//    }
//
//    @Override
//    @Transactional
//    public Employee getEmployee(int id) {
//        return employeeDAO.getEmployee(id);
//    }
//
//    @Override
//    @Transactional
//    public void deleteEmployee(int id) {
//        employeeDAO.deleteEmployee(id);
//    }
}
