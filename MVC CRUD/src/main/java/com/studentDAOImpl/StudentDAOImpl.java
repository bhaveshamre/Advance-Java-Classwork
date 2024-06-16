package com.studentDAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.student.model.StudentModel;
import com.student.util.SqlUtil;
import com.studentDAO.StudentDAO;

public class StudentDAOImpl implements StudentDAO {

	@Override
	public int save(StudentModel std) {
		int rs = -1;
		try {
			
			SqlUtil.Connect();
			String qry = "insert into student values("+std.getId()+",'"+std.getName()+"',"+std.getMarks()+","+std.getPhone()+",'"+std.getGender()+"','"+std.getCity()+"');";
			rs = SqlUtil.insert(qry);
			SqlUtil.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		return rs;
	}

	@Override
	public List<StudentModel> getAll() {
		List<StudentModel> stdList = new ArrayList<StudentModel>();
		try {
			SqlUtil.Connect();
			String qry = "select * from student;";
			ResultSet rs = SqlUtil.fetch(qry);
			if(rs!=null) {
				while(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString(2);
					float marks = rs.getFloat(3);
					int phone = rs.getInt(4);
					String gender = rs.getString(5);
					String city = rs.getString(6);
					StudentModel std = new StudentModel(id,name,marks,phone,gender,city);
					stdList.add(std);
				}
			}
			SqlUtil.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stdList;
	}

	@Override
	public StudentModel getById(int id) {
		StudentModel std = null;
		try {
			SqlUtil.Connect();
			String qry = "select * from student where id ="+id+";";
			ResultSet rs = SqlUtil.fetch(qry);
			if(rs!=null) {
				while(rs.next()) {
					int ud = rs.getInt("id");
					String name = rs.getString(2);
					float marks = rs.getFloat(3);
					int phone = rs.getInt(4);
					String gender = rs.getString(5);
					String city = rs.getString(6);
					std = new StudentModel(ud,name,marks,phone,gender,city);
					
				}
			}
			SqlUtil.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return std;
	}

	

	@Override
	public int remove(int id) {
		int rs = -1;
		try {
			SqlUtil.Connect();
			String qry = "delete from student where id ="+id;
			rs = SqlUtil.delete(qry);
			SqlUtil.close();
			
		} catch (Exception e) {			
			e.printStackTrace();
		}		
		return rs;
	}

	@Override
	public int update(int id, StudentModel std) {
		int rs =-1;
		try {
			SqlUtil.Connect();
			String qry = "update student set name='"+std.getName()+"', marks='"+std.getMarks()+"', phone ='"+std.getPhone()+"', gender ='"+std.getGender()+"', city ='"+std.getCity()+"' where id ='"+id+"';";
			rs = SqlUtil.update(qry);
			SqlUtil.close();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}

}
