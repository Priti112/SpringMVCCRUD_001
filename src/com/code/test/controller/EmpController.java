package com.code.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.code.test.dao.EmpDao;
import com.code.test.model.Emp;

@Controller
public class EmpController {
	
	@Autowired
	EmpDao dao;
	
	
	
	@RequestMapping("/")
	public String display() {
		return "index";
		
	}
	
	@RequestMapping("/viewemp")
	public String show(Model m) {
		List<Emp> list = dao.listAll();
		m.addAttribute("list", list);
		return "EmpList";
		
	}
	
	@RequestMapping("/new")
	public String showform(Model m) {
		//Emp emp = new Emp();
		m.addAttribute("command", new Emp());
		return "EmpEntry";
		
	}
	
	@RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
	public String editform(@PathVariable int id, Model m) {
		Emp e1 = dao.GetById(id);
		m.addAttribute("command", e1);
		return "EmpEntry";
		
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String deleteform(@PathVariable int id) {
		dao.delete(id);
		return "redirect:/viewemp";
		
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String saveform(Emp emp) {
		if(emp.getId() == 0) {
			dao.insert(emp);
		}
		else
		{
			dao.update(emp);
		}
		return "redirect:/viewemp";
		
	}

}
