package com.example.employeecrud;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.example.employeecrud.daoimpl.EmployeeDAOImpl;
import com.example.employeecrud.model.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       Scanner sc = new Scanner(System.in);
       EmployeeDAOImpl employeeDAOImpl = new EmployeeDAOImpl();
       char continuationChoice;
       do {
    	   System.out.println("1. Add employee\n2. Get all employees\n3. Get by id\n4. Remove employee\n5. Exit");
           System.out.print("Enter choice: ");
           int choice = sc.nextInt();
           if(choice==1) {
        	   Employee employee = new Employee();
        	   System.out.print("Enter name:");
        	   sc.nextLine();
        	   employee.setName(sc.nextLine());
        	   System.out.print("Enter phone:");
        	   employee.setPhone(sc.nextLine());
        	   System.out.print("Enter salary:");
        	   employee.setSalary(sc.nextFloat());
        	   int id = employeeDAOImpl.save(employee);
        	   System.out.println("Inserted id "+id);
           }
           else if(choice==2) {
        	   List<Employee> employees = employeeDAOImpl.getAll();
        	   if(employees.size()==0) {
        		   System.out.println("No employee found !");
        	   }
        	   else {
        		   Iterator<Employee> itr = employees.iterator();
        		   while(itr.hasNext()) {
        			   Employee employee = itr.next();
        			   System.out.println(employee);
        		   }
        	   }
           }
           else if(choice==3) {
        	   System.out.print("Enter id you want to search:");
        	   int id = sc.nextInt();
        	   Employee employee = employeeDAOImpl.getById(id);
        	   if(employee!=null) {
        		   System.out.println(employee);
        	   }
        	   else {
        		   System.out.println("Employee with given id not found");
        	   }
           }
           else if(choice==4){
        	   System.out.print("Enter id:");
        	   int id = sc.nextInt();
        	   int result = employeeDAOImpl.remove(id);
        	   if(result!=-1) {
        		   System.out.println("Employee removed!");
        	   }
        	   else {
        		   System.out.println("Employee with given id not found");
        	   }
           }
           else {
        	  System.out.println("Invalid choice"); 
           }
           System.out.print("Do you want to continue? (Y/N)");
           continuationChoice = sc.next().charAt(0);
       }
       while(continuationChoice=='Y');
       
       
    }
}
