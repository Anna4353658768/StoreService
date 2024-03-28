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
public class Product extends RepresentationModel<Product> implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private Float weight;
	private Float width;
	private Float height;
	private Float length;
    private Manufacturer manufacturer;
    
}



