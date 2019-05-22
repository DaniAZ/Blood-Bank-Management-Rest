package edu.mum.bloodbankrest.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Hospital {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;

	private String email;

	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	@OneToMany(mappedBy="hospital",fetch=FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private List<Request> requests = new ArrayList<>();

	public Hospital() {}

	public Hospital(String name, Address address, List<Request> requests) {
		this.name = name;
		this.address = address;
		this.requests = requests;
	}

	public void addRequest(Request request) {
		this.requests.add(request);
		request.setHospital(this);
	}


}
