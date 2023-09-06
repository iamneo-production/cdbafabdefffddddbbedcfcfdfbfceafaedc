package com.example.TaskManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.TaskManagement.entity.Management;

import jakarta.transaction.Transactional;


@Repository
public interface ManagementRepository extends JpaRepository<Management, Integer>{
	
	
	@Transactional
    @Modifying
    @Query(value="update Management m set m.taskstatus = ?1 where m.taskid = ?2",nativeQuery=true)
    void updateTask(String status,int id);
	
	List<Management> findBytaskNameLike(String taskName);

}
