package com.crudAppBoot.demo.Rest;

import com.crudAppBoot.demo.Entity.Customer;
import com.crudAppBoot.demo.Services.CustomerRepository.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController
{
    private CustomerService customerService;

    @Autowired
    public CustomerRestController(CustomerService customerService)
    {
        this.customerService = customerService;
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable int id)
    {
        return customerService.findById(id);
    }

    @GetMapping("/customers")
    public List getAllCustomers()
    {
        return customerService.findAll();
    }

    @DeleteMapping("/customer/{id}")
    public void deleteCustomerById(@PathVariable int id)
    {
        customerService.deleteById(id);
    }

    @PostMapping("/customer")
    public Customer addCustomer(@RequestBody Customer customer)
    {
        customer.setId(0);
        customerService.addCustomer(customer);
        return customer;
    }
    
    @PutMapping("/customer")
    public Customer updateCustomer(@RequestBody Customer customer)
    {
        customerService.updateCustomer(customer);
        return customer;
    }

}
