package ru.eshmakar.springboot_rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.eshmakar.springboot_rest.entity.Employee;
import ru.eshmakar.springboot_rest.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")//получаем список всех работников в формате json
    public List<Employee> showAllEmployee(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")//получаем одного работника в формате json
    public Employee getEmployee(@PathVariable int id){ //@PathVariable - используется чтобы читать данные из url
        Employee employee = employeeService.getEmployee(id);
        return employee;
    }

    @PostMapping("/employees")//добавляем работника методом POST
    public Employee addEmployee(@RequestBody Employee employee){//заполненяем данные работника с помощью Postman в формате json
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")//эта аннотация используется для изменения данных
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }


    @DeleteMapping("/employees/{id}")//используем для удаления работника
    public String deleteEmployee(@PathVariable int id){//получаем id с юзера
        Employee employee = employeeService.getEmployee(id);
        employeeService.deleteEmployee(id);//если есть такой работник, то удаляем из базы
        return "The employee with id " + id +" was deleted!";//возвращаем json
    }
}
