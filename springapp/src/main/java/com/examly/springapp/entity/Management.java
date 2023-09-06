package com.example.TaskManagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table( name="management",
schema="librarymanagement",
uniqueConstraints= {
		@UniqueConstraint(
				name= "taskHolderName_unique",
				columnNames="taskHolderName"
				)
        }
		)
public class Management {
	
  
  @Id
  @GeneratedValue(
		  
		  strategy = GenerationType.SEQUENCE,
			 generator = "management_generator"
		  )
  @SequenceGenerator(
			name="management_generator",
			sequenceName = "management_generator_name"
			)
  private int taskid;
  
  private String taskHolderName;
  private String taskDate;
  private String taskName;
  private String taskstatus;
public int getTaskid() {
	return taskid;
}
public void setTaskid(int taskid) {
	this.taskid = taskid;
}
public String getTaskHolderName() {
	return taskHolderName;
}
public void setTaskHolderName(String taskHolderName) {
	this.taskHolderName = taskHolderName;
}
public String getTaskDate() {
	return taskDate;
}
public void setTaskDate(String taskDate) {
	this.taskDate = taskDate;
}
public String getTaskName() {
	return taskName;
}
public void setTaskName(String taskName) {
	this.taskName = taskName;
}
public String getTaskstatus() {
	return taskstatus;
}
public void setTaskstatus(String taskstatus) {
	this.taskstatus = taskstatus;
}
  
  
  

}



