package com.crudAppBoot.demo.DAO;

import com.crudAppBoot.demo.Entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class EmployeeDAOHibernateImpl implements EmployeeDAO
{
    EntityManager entityManager;
    Session session ;
    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager entityManager)
    {
        this.entityManager = entityManager;
        this.session = entityManager.unwrap(Session.class);
    }



    @Override
    public List getEmployees()
    {

        Query query = session.createQuery("from Employee" , Employee.class);
        List employees = query.getResultList();
        return employees;
    }

    @Override
    public Employee getEmployeeById(int id)
    {
        Query query = session.createQuery("from Employee where id =:n");
        query.setParameter("n" , id);
        return (Employee) query.list().get(0);
    }


    @Override
    public void deleteEmployee(int id)
    {
        Query query = session.createQuery("delete from Employee where id=:n");
        query.setParameter("n" , id);
        query.executeUpdate();
    }

    @Override
    public void addEmployee(Employee employee)
    {
//        Query query = session.createQuery("insert into Employee (firstName , lastName , email) values ()")
        session.saveOrUpdate(employee);
    }


    @Override
    public void updateEmployee(Employee employee)
    {
//        Query query = session.createQuery("update  Employee set firstName=:a , lastName=:b , email=:c");
//        query.setParameter("a" , employee.getEmail())
          session.saveOrUpdate(employee);
    }


}
