package edu.mum.bloodbankrest.domain;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class Request {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne
	private BloodType blodType;
	private int quantity;

	@OneToOne
	private Status status;

	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="hospital_id")
	private Hospital hospital;
	
	public Request() {}

	public Request(Long id, BloodType blodType, int quantity, Status status) {
		this.id = id;
	   this.blodType = blodType;
		this.quantity = quantity;
		this.status = status;
		
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
}
