package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.StudentDTO;
@Repository
public interface StudentRepo extends CrudRepository<StudentDTO, Integer>{

}
