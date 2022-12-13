package com.FinalProject;

import java.sql.*;
import java.util.Scanner;
public class MainForJDBCApp  {
	static final Scanner obj=new Scanner(System.in);
	public static void update(Connection connection,int software_id) throws SQLException {//method for to update record
		PreparedStatement pstmt = connection.prepareStatement("update  softwaredetails set  price=? where software_id=?");//update query
		String value=obj.next();
		pstmt.setString(1,value);
		pstmt.setInt(2,software_id);

		int record=pstmt.executeUpdate();
		System.out.println(record);

	}

	public static void addSoftwareDetails(Connection connection,SoftwareDetails  obj) throws SQLException {//method for inserting values
		PreparedStatement pstmt = connection.prepareStatement("insert into softwaredetails values(?,?,?,?,?,?,?) ");//select query alike as in mysql
		pstmt.setString(1,obj.getsoftwarename());//antivirus
		pstmt.setInt(2,obj.getsoftware_id());//12
		pstmt.setString(3,obj.getsoftwaredescription());//to avoid virus
		pstmt.setInt(4,obj.getprice());//2000
		pstmt.setString(5,obj.getcompanyname()); //capgemini
		pstmt.setInt(6, obj.getrating());//4

		pstmt.setInt(7, obj.getstock());//200

		int record=pstmt.executeUpdate();//execute query
		System.out.println(record);//how many elements are added that means it will give count

	}
	public static void delete(Connection connection,int software_id) throws SQLException {//method for to delete record
		PreparedStatement pstmt = connection.prepareStatement("delete from softwaredetails where price=?");//dlete query
		int val=obj.nextInt();
		pstmt.setInt(1, val);
		int record=pstmt.executeUpdate();//execute query
		System.out.println(record);//how many records are 

	}
	public static void view(Connection connection,int software_id) throws SQLException {//method for to view record
		PreparedStatement pstmt = connection.prepareStatement("select * from softwaredetails where software_id=?");//selct query same as mysql
		int id=obj.nextInt();
		pstmt.setInt(1,id);
		ResultSet record=pstmt.executeQuery();
		while(record.next()) {
			System.out.println(record.getString(1)+" "+record.getInt(2)+" "+record.getString(3)+" "+record.getInt(4)+" "+record.getInt(5)+" "+record.getString(6)+" "+record.getInt(7));

		}

	}


	public static void main(String[] args)throws SQLException, Exception{
		Connection connection=null;
		//	final  SoftwareDetails addobj =new SoftwareDetails();//creating obj 
		Class.forName("com.mysql.cj.jdbc.Driver");//register driver class
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root" ,"Suhas3203@");//establishing connection
		System.out.println("enter 1 for addsoftwaredetails");
		System.out.println("enter 2 for updatesoftware");
		System.out.println("enter 3 for deletesoftware");
		System.out.println("enter 4 for viewsoftware");
		System.out.println("enter your choice");
		int choice = obj.nextByte();
		switch(choice) {
			case 1:
				SoftwareDetails obj =  getSoftwareDetails ();
				if(connection!=null) {
					addSoftwareDetails(connection,obj);//method call
				}
				else {
					System.out.println("check your connection");
				}


				break;
			case 2:

				System.out.println("enter which record do you want to update");
				update(connection,125);

				break;
			case 3:
				System.out.println("enter which record do you want to delete");
				delete(connection,125);

				break;
			case 4:
				System.out.println("enter id to read the record");
				view(connection,145);

				break;

			default:
				System.out.println("enter proper choice");
				connection.close();
		}

	}
	private static SoftwareDetails getSoftwareDetails() {//reading values from class SoftwareDetails
		SoftwareDetails user = new SoftwareDetails ();
		System.out.println("enter softwarename");
		user.setsoftwarename(obj.next());
		System.out.println("enter software_id");
		user.setsoftware_id(obj.nextInt());
		System.out.println("enter softwaredescription ");
		user.setsoftwaredescription(obj.next());
		System.out.println("enter price");
		user.setprice(obj.nextInt());
		System.out.println("enter companyname");
		user.setcompanyname(obj.next());
		System.out.println("enter rating");
		user.setrating(obj.nextInt());
		System.out.println("enter stock");
		user.setstock(obj.nextInt());
		return user;

	}



}


