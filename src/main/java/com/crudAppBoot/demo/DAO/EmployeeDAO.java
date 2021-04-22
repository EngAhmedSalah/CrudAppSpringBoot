package com.crudAppBoot.demo.DAO;

import com.crudAppBoot.demo.Entity.Employee;

import java.util.List;

public interface EmployeeDAO
{
    List getEmployees();
    Employee getEmployeeById(int id);
    void deleteEmployee (int id);
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee);
}
