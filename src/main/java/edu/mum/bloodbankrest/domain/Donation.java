package edu.mum.bloodbankrest.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import java.sql.Date;
import java.time.LocalDate;


@Entity
@Data
@JsonIgnoreProperties
public class Donation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private boolean viable = true;
	private int quantity;

	//@Future
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date donationDate;

	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="blood_drive_id")
	private BloodDrive bloodDrive;

	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="donor_id")
	private Donor donor;

	public Donation() {
	}
	public Donation(Long id, Boolean viable, int quantity,Date donationDate,Donor donor) {
		this.id = id;
		this.viable = viable;
		this.quantity = quantity;
		this.donationDate=donationDate;
	}

	public void setBloodDrive(BloodDrive bloodDrive) {
		this.bloodDrive = bloodDrive;
	}

	public void setDonor(Donor donor) {
		this.donor = donor;
	}

	public void setDonationDate(Date donationDate) {
		this.donationDate = donationDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isViable() {
		return viable;
	}

	public void setViable(boolean viable) {
		this.viable = viable;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getDonationDate() {
		return donationDate;
	}

	public BloodDrive getBloodDrive() {
		return bloodDrive;
	}

	public Donor getDonor() {
		return donor;
	}
}
