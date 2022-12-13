package com.example.projectSecond.SoftwaresBluePrint;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;


@Entity
@Table(name="Software_Management_System")
public class Softwares {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int Sr_No;

	@Size(max=10,min=5,message="criteria not met")
	@Valid
	@Column(name="Software_Name", nullable = false,length=30)
	private String nameOfSoftware;

	@Size(max=10,min=5,message="criteria not met")
	@Valid
	@Column(name="Software_Creator",nullable = false,length=15)
	private String creatorOfSoftware;

	@Max(value=7)
	@Valid
	@Column(name="Software_Price", length=10)
	private int price;

	@Max(value=1)
	@Valid
	@Column(name="Software_Rating",length=1)
	private byte rating;

	@Max(value=5)
	@Valid
	@Column(name="Software_Stock",length=3)
	private int stockOfSoftware;


	public Softwares() {

	}
	public Softwares(String nameOfSoftware, String creatorOfSoftware, int price, byte rating,
			int stockOfSoftware) {

		this.nameOfSoftware = nameOfSoftware;
		this.creatorOfSoftware = creatorOfSoftware;
		this.price = price;
		this.rating = rating;
		this.stockOfSoftware = stockOfSoftware;
	}

	public int getSr_No() {
		return Sr_No;
	}

	public void setSr_No(int sr_No) {
		Sr_No = sr_No;
	}

	public String getNameOfSoftware() {
		return nameOfSoftware;
	}

	public void setNameOfSoftware(String nameOfSoftware) {
		this.nameOfSoftware = nameOfSoftware;
	}

	public String getCreatorOfSoftware() {
		return creatorOfSoftware;
	}

	public void setCreatorOfSoftware(String creatorOfSoftware) {
		this.creatorOfSoftware = creatorOfSoftware;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public byte getRating() {
		return rating;
	}

	public void setRating(byte rating) {
		this.rating = rating;
	}

	public int getStockOfSoftware() {
		return stockOfSoftware;
	}

	public void setStockOfSoftware(int stockOfSoftware) {
		this.stockOfSoftware = stockOfSoftware;
	}


}
