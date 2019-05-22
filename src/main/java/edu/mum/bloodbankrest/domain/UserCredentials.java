package edu.mum.bloodbankrest.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class UserCredentials {

	@Id
	private Long id;
	@Column(nullable = true, unique = true ,length = 16)
	String username;
	@Column(nullable = false)
	String password;

	@Transient
	String verifyPassword;
	Boolean enabled;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="credentials_id")
	List<Authority> authority = new ArrayList<Authority>();

}