package com.example.demo.service;

import com.example.demo.dto.StudentDTO;

public interface StudentServiceInterface {

	StudentDTO saveStudent(StudentDTO student);
	
	StudentDTO find(StudentDTO student);
	
	String delete(StudentDTO studentDTO);
	
	StudentDTO update(StudentDTO student);
}
