package com.example.ratings;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Table(name="employees")
public class Employee{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name="Name")
	private String name;
	@Column(name="Email")
	private String email;
	@Column(name="Contact")
	private Integer contact;
	@Column(name="Rating")
	private Integer rating;
}