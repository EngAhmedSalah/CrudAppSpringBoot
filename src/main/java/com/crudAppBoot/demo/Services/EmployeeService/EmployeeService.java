package com.crudAppBoot.demo.Services.EmployeeService;

import com.crudAppBoot.demo.Entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService
{
    List getEmployees();
    Employee getEmployeeById(int id);
    void deleteEmployee (int id);
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
}
