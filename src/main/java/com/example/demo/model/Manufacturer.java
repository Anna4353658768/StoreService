package com.example.demo.model;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Manufacturer extends RepresentationModel<Manufacturer> implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String country;
	private String person;
	private String phone;

}


