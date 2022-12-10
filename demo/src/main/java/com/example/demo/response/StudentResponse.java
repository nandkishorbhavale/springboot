package com.example.demo.response;

import com.example.demo.dto.StudentDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {

	private StudentDTO student;
	
	Iterable<StudentDTO> list;
	
	private String msg;
}
