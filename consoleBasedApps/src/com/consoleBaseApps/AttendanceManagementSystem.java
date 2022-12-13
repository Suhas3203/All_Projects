package com.consoleBaseApps;

import java.util.Scanner;

public class AttendanceManagementSystem  {

	private String employeeName;
	private byte noOfPresentDays;
	private byte noOfAbsentDays;
	private char presentStatus;
	private final static byte absentAllowed=5;
	static int flagValue;
	void toCheckAttendanceData() {
		System.out.println(employeeName + "'s total days of present are "+ noOfPresentDays);
	}

	public void getNoOfAbsentDays() {
		this.noOfAbsentDays += noOfAbsentDays;
		System.out.println("Total Leaves Taken by "+employeeName+" are - "+this.noOfAbsentDays);
	}

	public void setPresentStatus(char presentStatus) {
		if(presentStatus=='p'|presentStatus=='P') {
			noOfPresentDays+=1;
			this.presentStatus = presentStatus;
			System.out.println("Attendance saved successfully with status "+ this.presentStatus +" as present");
		}
		else {
			System.out.println("You have entered incorrect details.");
		}

	}

	public void setIsAbsent(char presentStatus) {

		if(presentStatus=='a'|presentStatus=='A' && noOfAbsentDays<=absentAllowed) {
			noOfAbsentDays+=1;
			this.presentStatus = presentStatus;
			System.out.println("Your leave is allowed");
		}

		else {
			System.out.println("You are not allowed to take leave because already your leaves are "+ noOfAbsentDays);
			//	flagValue=1;
		}
	}

	private void exit(int i) {
		System.out.println("You have been sucessfully logged out...");
	}

	AttendanceManagementSystem(String employeeName){
		this.employeeName=employeeName;

	}
	public static void main (String[] args) throws InterruptedException {


		Scanner scanObj=new Scanner(System.in);
		System.out.print("Please Enter your Name to access your Account :- ");
		String employeeName=scanObj.nextLine();
		AttendanceManagementSystem adminStaffObj=new AttendanceManagementSystem(employeeName);
		//	AttendanceManagementSystem departmentalStaffObj=new AttendanceManagementSystem(employeeName);
		//	AttendanceManagementSystem employeesObj=new AttendanceManagementSystem(employeeName);
		byte inputChoice;

		System.out.println("Welcome Mr./Ms. "+employeeName+" for Attendance Management System of ABC.pvt.ltd.");

		do {

			System.out.println();
			System.out.println("Press 1 for check present days");
			System.out.println("Press 2 for check Absent days");
			System.out.println("Press 3 for adding present status");
			System.out.println("Press 4 for for applying to leave");
			System.out.println("Press 5 for exit");

			System.out.print("Please Enter your choice :- ");
			inputChoice =scanObj.nextByte();
			switch(inputChoice) {

			case 1:
				adminStaffObj.toCheckAttendanceData();
				break;
			case 2:
				adminStaffObj.getNoOfAbsentDays();
				break;
			case 3:
				System.out.print("Please enter present status as P/present :- ");
				String presentStatus=scanObj.next();
				adminStaffObj.setPresentStatus(presentStatus.charAt(0));
				break;
			case 4:
				System.out.print("Please enter absent status as A/absent:- ");
				String absentStatus=scanObj.next();
				adminStaffObj.setIsAbsent(absentStatus.charAt(0));

				break;
			case 5:
				adminStaffObj.exit(0);
				flagValue=1;
				break;
			}
			if(flagValue==1) {
				flagValue=0;
				break;
			}
		}while(inputChoice <=4);

		scanObj.close();
	}


}