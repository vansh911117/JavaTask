package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
	@Autowired
	MyRepo repo;
	@RequestMapping("/home")
public String show()
{
	return "first";
}
	@RequestMapping("/addstudent")
	public String addStudent(Student s,Model m)
	{
		repo.save(s);
		m.addAttribute("s", s);
		return "home";
	}
	@RequestMapping("/shows")
	public String show(Model m)
	{
		List<Student> al=(List<Student>) repo.findAll();
		m.addAttribute("data", al);
		return "shows";
	}
	@RequestMapping("/searchbyid")
	public String searchById(@RequestParam("id") int id,Model m)
	{
		Student s=repo.findById(id).orElse(new Student());
		m.addAttribute("s", s);
		return "searchbyid";
	}
	@RequestMapping("/searchbyname")
	public String searchById(@RequestParam("name") String name,Model m)
	{
		Student s=repo.findByName(name);
		m.addAttribute("s", s);
		return "searchbyid";
	}
	@RequestMapping("/delete")
	public String deleteStudent(@RequestParam("id") int id,Model m)
	{
		Student s=repo.findById(id).orElse(new Student());
		repo.delete(s);
		List<Student> al=(List<Student>) repo.findAll();
		m.addAttribute("data", al);
		return "shows";
	}
	@RequestMapping("/update")
	public String updateStudent(Student s,Model m)
	{
		repo.save(s);
		List<Student> al=(List<Student>) repo.findAll();
		m.addAttribute("data", al);
		return "shows";
	}

}
