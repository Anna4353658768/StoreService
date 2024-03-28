package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Manufacturer;
import com.example.demo.service.ManufacturerService;

@RestController
@RequestMapping(value="v1/manufacturers")
public class ManufacturerController {
	
	@Autowired
	private ManufacturerService manufacturerService;

	
	@GetMapping("/{manufacturerId}")
	public ResponseEntity<Manufacturer> getManufacturer(@PathVariable("manufacturerId") String manufacturerId) {
		
		Manufacturer manufacturer = manufacturerService.getManufacturer(manufacturerId);
		
		manufacturer.add(
				WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ManufacturerController.class)
						.getManufacturer(manufacturer.getId().toString())).withSelfRel(),
				
				WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ManufacturerController.class)
						.createManufacturer(manufacturer)).withRel("createManufacturer"),
				
				WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ManufacturerController.class)
						.updateManufacturer(manufacturer)).withRel("updateManufacturer"),
				
				WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ManufacturerController.class)
						.deleteManufacturer(manufacturer.getId().toString())).withRel("deleteManufacturer"));
		
		return ResponseEntity.ok(manufacturer);
	}
	
	
	@PutMapping
	public ResponseEntity<String> updateManufacturer(@RequestBody Manufacturer manufacturer) {
		return ResponseEntity.ok(manufacturerService.updateManufacturer(manufacturer));
	}
	
	
	@PostMapping
	public ResponseEntity<String> createManufacturer(@RequestBody Manufacturer manufacturer) {
		return ResponseEntity.ok(manufacturerService.createManufacturer(manufacturer));
	}
	
	
	@DeleteMapping(value="/{manufacturerId}")
	public ResponseEntity<String> deleteManufacturer(@PathVariable("manufacturerId") String manufacturerId) {
		return ResponseEntity.ok(manufacturerService.deleteManufacturer(manufacturerId));
	}

	

}
