package edu.mum.bloodbankrest.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Data
public class Address {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotEmpty
	private String street;
	@NotEmpty
	private String city;

	@Size(min = 5, max = 10)
	private String zipCode;

	@OneToOne(fetch=FetchType.EAGER)
	private State state;

	public Address() {
	}
	public Address(String street, String city, String zipCode,State state) {
		super();
		this.street = street;
		this.city = city;
		this.zipCode = zipCode;
		this.state=state;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
}
