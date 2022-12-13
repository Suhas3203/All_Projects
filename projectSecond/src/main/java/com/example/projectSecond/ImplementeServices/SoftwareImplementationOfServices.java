package com.example.projectSecond.ImplementeServices;

import java.util.List;

import com.example.projectSecond.SoftwaresBluePrint.Softwares;
import com.example.projectSecond.SoftwaresServices.ApplicationServices;
import com.example.projectSecond.jpaRepository.ProjectRepository;

import org.springframework.stereotype.Service;

@Service
public class SoftwareImplementationOfServices implements ApplicationServices {
	private ProjectRepository softwareProject;

	public SoftwareImplementationOfServices(ProjectRepository softwareProject) {

		this.softwareProject = softwareProject;
	}

	@Override
	public Softwares insertNewSoftware(Softwares Obj) {

		return softwareProject.save(Obj);
	}

	@Override
	public List<Softwares> viewAllSoftwares() {

		return softwareProject.findAll();
	}

	@Override
	public Softwares updateExisitingRecord(Softwares newSoftware) {

		return softwareProject.save(newSoftware);
	}

	@Override
	public Softwares getSoftwareWithId(int id) {

		return softwareProject.findById(id).get();  //.get method is for optional choice
	}

	@Override
	public void deleteSoftwareFromDB(int id) {
		softwareProject.deleteById(id);

	}

}
