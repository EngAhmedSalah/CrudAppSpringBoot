package com.crudAppBoot.demo.Rest;

import com.crudAppBoot.demo.Entity.Employee;
import com.crudAppBoot.demo.Services.EmployeeService.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class restController
{
    private EmployeeService employeeService;

    @Autowired
    public restController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List getAllEmplyees()
    {
        return employeeService.getEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id)
    {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee)
    {
        //so just passed employee JSON object , set id to 0 it will save a new item instead of update
        employee.setId(0);
        employeeService.addEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id)
    {
        employeeService.deleteEmployee(id);
        return  "Deleted employee" + id;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee)
    {
        employeeService.updateEmployee(employee);
        return employee;
    }
    @GetMapping("/hijri")
    public String getHijriCalender()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        String url = "http://api.aladhan.com/v1/gToH?date="+formatter.format(date);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url , String.class);
    }
}
