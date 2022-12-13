package com.example.projectSecond.SoftwaresServices;

import java.util.List;

import com.example.projectSecond.SoftwaresBluePrint.Softwares;

public interface ApplicationServices {

	List<Softwares> viewAllSoftwares();
	
	Softwares insertNewSoftware(Softwares Obj);
	
	Softwares getSoftwareWithId(int id);
	
	Softwares updateExisitingRecord(Softwares newSoftware);
	
	void deleteSoftwareFromDB(int id);
}
