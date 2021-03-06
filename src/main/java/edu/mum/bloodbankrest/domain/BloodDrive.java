package edu.mum.bloodbankrest.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@JsonIgnoreProperties
public class BloodDrive {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String driveName;
	private String phoneNumber;

	@Email
	private String email;

	@Valid
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	@OneToMany(mappedBy="bloodDrive",fetch=FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<Donation> donations = new HashSet<Donation>();


	public BloodDrive() {}

	public BloodDrive(String driveName, String phoneNumber, String email, Address address) {
		this.driveName = driveName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
	}

	public void addDonation(Donation donation) {
		this.donations.add(donation);
		donation.setBloodDrive(this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDriveName() {
		return driveName;
	}

	public void setDriveName(String driveName) {
		this.driveName = driveName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Donation> getDonations() {
		return donations;
	}

	public void setDonations(Set<Donation> donations) {
		this.donations = donations;
	}
}
