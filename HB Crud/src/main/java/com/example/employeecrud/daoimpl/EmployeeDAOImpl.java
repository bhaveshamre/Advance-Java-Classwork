package com.example.employeecrud.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.employeecrud.dao.EmployeeDAO;
import com.example.employeecrud.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

    private SessionFactory sessionFactory;
    private Session session;

    public EmployeeDAOImpl() {
        Configuration configuration = new Configuration();
        configuration.configure().addAnnotatedClass(Employee.class);
        sessionFactory = configuration.buildSessionFactory();
    }

    @Override
    public Integer save(Employee employee) {
        Transaction transaction = null;
        Integer id = null;
        
        try {
        	session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            id = (Integer) session.save(employee);
            transaction.commit(); //
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return id;
    }

    @Override
    public List<Employee> getAll() {
        Transaction transaction = null;
        session = sessionFactory.openSession();
        List<Employee> employeesList = new ArrayList<>();
        try {
           
            transaction = session.beginTransaction();
            employeesList = session.createQuery("FROM Employee ORDER BY name", Employee.class).list();


			/* transaction.commit(); */
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employeesList;
    }

    @Override
    public Employee getById(int id) {
        Transaction transaction = null;
        Employee employee = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            employee = session.get(Employee.class, id);
			/* transaction.commit(); */
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employee;
    }

    @Override
    public int remove(int id) {
        Transaction transaction = null;
        int result = -1;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Employee employee = session.get(Employee.class, id);
            if (employee != null) {
                session.delete(employee);
                transaction.commit();
                result = 1;
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public int update(int id, String name, String phone, float salary) {
        Transaction transaction = null;
        int result = -1;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Employee employee = session.get(Employee.class, id);
            if (employee != null) {
                employee.setName(name);
                employee.setPhone(phone);
                employee.setSalary(salary);
                session.update(employee);
                transaction.commit();
                result = 1;
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }
}
