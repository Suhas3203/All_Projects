package com.example.projectSecond.AppController;

import com.example.projectSecond.ImplementeServices.SoftwareImplementationOfServices;
import com.example.projectSecond.SoftwaresBluePrint.Softwares;
import com.example.projectSecond.adminDetails.AdminDetails;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ApplicationController {

	SoftwareImplementationOfServices softwareServices;

	public ApplicationController(SoftwareImplementationOfServices softwareServices) {
		this.softwareServices = softwareServices;
	}

	@GetMapping("/home")
	public String viewHomePage(Model modelObj) {
		return "homePage";
	}

	@GetMapping("/companyInfo")
	public String viewCompaniesPersonalInfo(Model model) {
		return "companyInfo";
	}

	@GetMapping("/viewAllSoftwaresInfo")
	public String viewAllSoftwares(Model modelObj) {
		modelObj.addAttribute("softwaresList", softwareServices.viewAllSoftwares());
		return "softwareData";
	}

	@GetMapping("/addNewSoftware")
	public String addNewSoftwareDetails(Model modelObj) {
		Softwares newObj=new Softwares();
		modelObj.addAttribute("softwareDetails",newObj);
		return "createASoftwareInfo";
	}

	@PostMapping("/insertNewSoftware")
	public String insertSoft(@ModelAttribute("softwareDetails") Softwares newSoftware ){
		softwareServices.insertNewSoftware(newSoftware);
		return "redirect:/viewAllSoftwaresInfo";
	}

	@GetMapping("/softwareEdit/{Sr_No}")
	public String editExistingSoftware(@PathVariable("Sr_No") int id,Model model) {
		model.addAttribute("softwareFromDatabase",softwareServices.getSoftwareWithId(id));
		return "viewUpdatingSoftware";
	}

	@PostMapping("/updateSoftware/{Sr_No}")  //In form only GET and POST mapping can be used
	public String updateExistingSoftware(@PathVariable("Sr_No") int id,@ModelAttribute("softwareFromDatabase") Softwares existingSoftware,Model model) {
		Softwares newSoftware = softwareServices.getSoftwareWithId(id);
		newSoftware.setSr_No(id);
		newSoftware.setNameOfSoftware(existingSoftware.getNameOfSoftware());
		newSoftware.setCreatorOfSoftware(existingSoftware.getCreatorOfSoftware());
		newSoftware.setPrice(existingSoftware.getPrice());
		newSoftware.setRating(existingSoftware.getRating());
		newSoftware.setStockOfSoftware(existingSoftware.getStockOfSoftware());
		softwareServices.updateExisitingRecord(newSoftware);
		return "redirect:/viewAllSoftwaresInfo";
	}

	@GetMapping("/deleteSoftware/{Sr_No}")
	public String deleteASoftware(@PathVariable("Sr_No") int id) {
		softwareServices.deleteSoftwareFromDB(id);
		return "redirect:/viewAllSoftwaresInfo";
	}

	@GetMapping("/logoutFromApp")
	public String logoutFromApplication() {
		return "logoutPage";
	}

	@GetMapping("/login")
	public String loginToApplication(Model model) {
		AdminDetails admin=new AdminDetails();

		model.addAttribute("adminObj", admin);
		return "loginPage";
	}

	@GetMapping("/validatingData")
	public String validationOfLoginCredentials(@ModelAttribute("adminObj") AdminDetails adminData) {
		if(adminData.getUsername().equals("suhas3203@gmail.com") && adminData.getPassword().equals("Suhas3203")) {
			return "redirect:/home";
		}
		else {
			return "redirect:/login";
		}

	}
}

