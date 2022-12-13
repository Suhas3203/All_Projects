package com.example.projectSecond.jpaRepository;

import com.example.projectSecond.SoftwaresBluePrint.Softwares;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Softwares, Integer> {
	
}
