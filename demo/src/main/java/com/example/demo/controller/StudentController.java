package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.StudentDTO;
import com.example.demo.response.StudentResponse;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService service;
	
	@PostMapping("/save")
	public ResponseEntity<StudentResponse> save(@RequestBody StudentDTO student){
		StudentDTO studentSave = service.saveStudent(student);
		return new ResponseEntity<StudentResponse>(new StudentResponse(studentSave , null, "student saved"),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<StudentResponse> remove(@RequestBody StudentDTO student){
		String delete = service.delete(student);
		return new ResponseEntity<StudentResponse>(new StudentResponse(null , null, delete),HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/update")
	public ResponseEntity<StudentResponse> update(@RequestBody StudentDTO student){
		StudentDTO existingStudent = service.find(student);
		existingStudent.setId(student.getId());
		existingStudent.setName(student.getName());
		existingStudent.setAge(student.getAge());
		existingStudent.setContact(student.getContact());
		
		// save updated student object
		StudentDTO studentUpdated = service.update(existingStudent);		
		return new ResponseEntity<StudentResponse>(new StudentResponse(studentUpdated , null, "student Updated"),HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/get")
	public ResponseEntity<StudentResponse> get(@RequestBody StudentDTO student){
		StudentDTO findStudent = service.find(student);
		return new ResponseEntity<StudentResponse>(new StudentResponse(findStudent , null, "student saved"),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<StudentResponse> getAll(){
		Iterable<StudentDTO> findAllStudent = service.findAll();
		return new ResponseEntity<StudentResponse>(new StudentResponse(null , findAllStudent, "student saved"),HttpStatus.ACCEPTED);
	}
	
}
