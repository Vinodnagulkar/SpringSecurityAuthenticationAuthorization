package com.security.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.model.Subject;

/**
 * @author Vinod.nagulkar
 *
 */
@RestController
public class TrainerController 
{
	static List<Subject> sublist = new ArrayList<Subject>(Arrays.asList(
			new Subject(1,"JAVA"),
			new Subject(2,"SPRINGBOOT"),
			new Subject(3,"ANGULAR"),
			new Subject(4,"REACT")));	
	
	
	@PostMapping("/trainer/saveSubject")
	public List<Subject> saveEmployee(@RequestBody Subject sub)
	{
		System.out.println(sub.toString());
		sublist.add(sub);
		return sublist;
	}
	
	@GetMapping("/trainer/getSubject/{id}")
	public Stream<Subject> getSubject(@PathVariable int id) {
		return sublist.stream().filter(sub->id==sub.getSubId());
	}
	
	@GetMapping("/trainer/getAllSubject")
	public List<Subject> getSubject() {
		return sublist;
	}
	
	@GetMapping("/trainer/deleteSubject/{id}")
	public List<Subject> deleteSubject(@PathVariable int id) 
	{
		//return emplist.stream().filter(p->id!=p.getEmpId()).collect(Collectors.toList());
		Iterator<Subject> itr = sublist.iterator();
		while (itr.hasNext()) {
			Subject subject = (Subject) itr.next();
			if (subject.getSubId()==id) {
				itr.remove();
			}
		}
		return sublist;
	}
}
