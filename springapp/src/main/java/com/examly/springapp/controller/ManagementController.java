package com.example.TaskManagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.TaskManagement.entity.Management;
import com.example.TaskManagement.repository.ManagementRepository;

@Controller
public class ManagementController {
	
	@Autowired
	private ManagementRepository repo;
	
	@RequestMapping("/")
	@ResponseBody
	public String home(@RequestParam int taskid,String name,String date,String taskname,String progress)
	{
		
		Management manage=new Management();
		manage.setTaskid(taskid);
		manage.setTaskHolderName(name);
		manage.setTaskDate(date);
		manage.setTaskName(taskname);
		manage.setTaskstatus(progress);
		repo.save(manage);
		return "Welcome to Task Management!";
	}
	
	@RequestMapping("/saveTask") 
	@ResponseBody
	public List<Management> saveTask()
	{
		return repo.findAll();
	}
	
	@RequestMapping("/changeStatus")
	@ResponseBody
	public Optional<Management> updateTask(@RequestParam int id)
	{
		String status="Completed";
		repo.updateTask(status, id);
		Optional<Management> manage1=repo.findById(id);
		return manage1;
		 
	}
	
	@RequestMapping("/deleteTask")
	@ResponseBody
	public String DeleteTask(@RequestParam int id)
	{
		repo.deleteById(id);
		return "Delete Sucessful!";
	}
	
	@RequestMapping("/getTask")
	@ResponseBody
	public ResponseEntity<List<Management>> getProductsByType(@RequestParam String taskName) {
			return new ResponseEntity<List<Management>>(repo.findBytaskNameLike("%"+taskName+"%"), HttpStatus.OK);
		}
	

}
