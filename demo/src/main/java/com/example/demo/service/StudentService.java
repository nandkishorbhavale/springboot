package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.StudentDTO;
import com.example.demo.repository.StudentRepo;
@Service
public class StudentService implements StudentServiceInterface{

	@Autowired
	StudentRepo repo;
	
	public StudentDTO saveStudent(StudentDTO student) {
		if (student != null) {
			StudentDTO studentSaved = repo.save(student);
			return studentSaved;
		}
		return null;
	}

	public StudentDTO find(StudentDTO student) {
		if (student != null) {
			Optional<StudentDTO> found = repo.findById(student.getId());
			return found.get();
		}
		return null;
	}

	public String delete(StudentDTO student) {
		if (student != null) {
			repo.delete(student);
			return "Successfully removed Student";
		}
		return null;
	}

	public StudentDTO update(StudentDTO student) {
		if (student != null) {
			StudentDTO studentUpdate = repo.save(student);
			return studentUpdate;
		}
		return null;
	}
	
	public Iterable<StudentDTO> findAll(){
			Iterable<StudentDTO> findAll = repo.findAll();
			return findAll;
	}

}
