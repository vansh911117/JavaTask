package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MyRepo extends JpaRepository<Student, Integer>{

}
