package com.crudAppBoot.demo.Services.CustomerRepository;

import com.crudAppBoot.demo.DAO.CustomerRepository;
import com.crudAppBoot.demo.DAO.EmployeeDAO;
import com.crudAppBoot.demo.Entity.Customer;
import com.crudAppBoot.demo.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CustomerServiceImpl implements CustomerService
{

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository)
    {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll()
    {
        return customerRepository.findAll();
    }


    @Override
    public Customer findById(Integer id)
    {
        Optional<Customer> result = customerRepository.findById(id);
        if(result.isPresent())
            return result.get();
        else
            throw new RuntimeException("Customer Not Found");
    }

    @Override
    public String deleteById(Integer id)
    {
        customerRepository.deleteById(id);
        return "Customer has been deleted Successfully";
    }

    @Override
    public void addCustomer(Customer customer)
    {
        customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        customerRepository.saveAndFlush(customer);
        return customer;
    }
}
