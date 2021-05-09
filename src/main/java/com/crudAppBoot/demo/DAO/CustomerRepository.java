package com.crudAppBoot.demo.DAO;

import com.crudAppBoot.demo.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CustomerRepository extends JpaRepository<Customer , Integer>
{

}