package com.crudAppBoot.demo.Services.EmployeeService;

import com.crudAppBoot.demo.DAO.EmployeeDAO;
import com.crudAppBoot.demo.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService
{
    @Autowired
    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO)
    {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List getEmployees() {
        return employeeDAO.getEmployees();
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeDAO.getEmployeeById(id);
    }

    @Override
    public void deleteEmployee(int id)
    {
        employeeDAO.deleteEmployee(id);
    }

    @Override
    public void addEmployee(Employee employee)
    {
        employeeDAO.addEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeDAO.updateEmployee(employee);
    }
}
