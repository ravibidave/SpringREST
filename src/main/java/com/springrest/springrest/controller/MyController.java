package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;

@RestController
public class MyController {
	
	   @Autowired	
	   private CourseService courseSerivice;
        
	   
	   @GetMapping("/home")
	   public String home() {
		   return "Welcome to courses application";
	   }

        //get the courses
	   
	   @GetMapping("/courses")
	   public List<Course> getCourses()
	   {
		
		   return this.courseSerivice.getCourses();
		   
	   }
	   
	   //get the single courses
	   @GetMapping("/courses/{courseId}")
	   public Course getCourse(@PathVariable String courseId)
	   {
		   return this.courseSerivice.getCourse(Long.parseLong(courseId));
	   }
	   
	   // to add the course
	   @PostMapping("/courses")
	   public Course addCourse(@RequestBody Course course)
	   {
		   
		   return this.courseSerivice.addCourse(course);
	   }
}
