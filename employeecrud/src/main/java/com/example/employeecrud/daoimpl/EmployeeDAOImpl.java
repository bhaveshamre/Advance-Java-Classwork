package com.example.employeecrud.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.employeecrud.dao.EmployeeDAO;
import com.example.employeecrud.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO{

	private SessionFactory sessionFactory;
	private Session session;
	private Configuration configuration;
	
	public EmployeeDAOImpl() {
		configuration = new Configuration();
		configuration.configure().addAnnotatedClass(Employee.class);
		sessionFactory = configuration.buildSessionFactory();
	}
	
	@Override
	public Integer save(Employee employee) {
		session = sessionFactory.openSession();
		Transaction transaction = null;
		Integer id = null;
		try {
			transaction = session.beginTransaction();
			id =(Integer)session.save(employee);
			transaction.commit();
		} catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return id;
	}

	@Override
	public List<Employee> getAll() {
		session = sessionFactory.openSession();
		Transaction transaction = null;
		List<Employee> employeesList=new ArrayList<Employee>();
		try {
			transaction = session.beginTransaction();
			employeesList = session.createQuery("FROM Employee").list();
			transaction.commit();
		} catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return employeesList;
	}

	@Override
	public Employee getById(int id) {
		session = sessionFactory.openSession();
		Transaction transaction = null;
		Employee employee = null;
		try {
			transaction = session.beginTransaction();
			employee = session.get(Employee.class,id);
			transaction.commit();
		} catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return employee;
	}

	@Override
	public int remove(int id) {
		session = sessionFactory.openSession();
		Transaction transaction = null;
		int result = -1;
		try {
			transaction = session.beginTransaction();
			Employee employee = session.get(Employee.class,id);
			if(employee!=null) {
				session.delete(employee);
				transaction.commit();
				result = 1;
			}
			
		} catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return result;
	}

	@Override
	public int update(int id, String name, String phone, float salary) {
		session = sessionFactory.openSession();
		Transaction transaction = null;
		int result = -1;
		try {
			transaction = session.beginTransaction();
			Employee employee = session.get(Employee.class,id);
			if(employee!=null) {
				employee.setName(name);
				employee.setPhone(phone);
				employee.setSalary(salary);
				session.update(employee);
				transaction.commit();
				result = 1;
			}
			
		} catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return result;
	}

}
