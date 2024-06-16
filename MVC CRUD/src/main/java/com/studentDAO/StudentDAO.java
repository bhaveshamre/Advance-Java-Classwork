package com.studentDAO;

import java.util.List;

import com.student.model.StudentModel;

public interface StudentDAO {

	int save (StudentModel std);
	List<StudentModel> getAll();
	StudentModel getById(int id);
	int remove(int id);
	int update(int id, StudentModel std);
}
