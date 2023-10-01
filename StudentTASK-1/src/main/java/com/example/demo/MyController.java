package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
@Autowired
MyRepo repo;
@GetMapping("/shows")
public List<Student> show()
{
	return repo.findAll();
}
@PostMapping("/add")
public Student addStudent(@RequestBody Student s)
{
	return repo.save(s);
}
@DeleteMapping("/add/{id}")
public String delete(@PathVariable("id") int id)
{
	Optional<Student> s=repo.findById(id);
	if(s==null || s.isEmpty())
	{
		return "not found";
	}
	else {
		repo.deleteById(id);
		return "deleted";
	}
}
@PutMapping("add/{id}")
public Student update(@PathVariable("id") int id,@RequestBody Student s)
{
	Optional<Student> s1=repo.findById(id);
	if(s1==null || s1.isEmpty())
	{
		return new Student();
	}else
	{
		s.setId(id);
		return repo.save(s);
	}
}
@GetMapping("/show/{id}")
public Optional<Student> search(@PathVariable("id") int id)
{
	return repo.findById(id);
}
}
