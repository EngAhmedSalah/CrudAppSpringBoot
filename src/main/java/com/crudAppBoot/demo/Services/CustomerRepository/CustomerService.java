package com.crudAppBoot.demo.Services.CustomerRepository;

import com.crudAppBoot.demo.Entity.Customer;
import com.crudAppBoot.demo.Entity.Customer;

import java.util.List;
import java.util.Optional;


public interface CustomerService
{
    public List<Customer> findAll();
    Customer findById(Integer id);
    String deleteById(Integer id);
    void addCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
}
