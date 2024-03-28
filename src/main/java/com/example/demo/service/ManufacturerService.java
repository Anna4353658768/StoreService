package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Manufacturer;

@Service
public class ManufacturerService {
	
	public Manufacturer getManufacturer(String manufacturerId) {
		
		Manufacturer manufacturer = new Manufacturer();
		manufacturer.setId(Long.parseLong(manufacturerId));
		manufacturer.setName("ООО Простаквашено");
		manufacturer.setCountry("Россия");
		manufacturer.setPerson("Попова А.Е.");
		manufacturer.setPhone("+79235446323");
		
		return manufacturer;
	}
	
	
	public String createManufacturer(Manufacturer manufacturer){
		String responseMessage = null;
		if(manufacturer != null) {
			responseMessage = String.format("This is the post and the object is: %s", manufacturer.toString());
		}
		return responseMessage;
	}
	
	
	public String updateManufacturer(Manufacturer manufacturer){
		String responseMessage = null;
		if (manufacturer != null) {
			responseMessage = String.format("This is the put and the object is: %s", manufacturer.toString());
		}
		return responseMessage;
	}
	
	
	public String deleteManufacturer(String manufacturerId){
		String responseMessage = null;
		responseMessage = String.format("Deleting license with id %s", manufacturerId);
		return responseMessage;
	}

}
