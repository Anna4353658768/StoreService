package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Manufacturer;
import com.example.demo.model.Product;


@Service
public class ProductService {
	
	public Product getProduct(String productId) {
		
		Manufacturer manufacturer = new Manufacturer();
		manufacturer.setId(1L);
		manufacturer.setName("ООО Простаквашено");
		manufacturer.setCountry("Россия");
		manufacturer.setPerson("Попова А.Е.");
		manufacturer.setPhone("+79235446323");
		
		Product product = new Product();
		product.setId(Long.parseLong(productId));
		product.setName("ООО ПрофТест");
		product.setWeight(5F);
		product.setWidth(5F);
		product.setHeight(5F);
		product.setLength(5F);
		product.setManufacturer(manufacturer);

		return product;
	}
	
	
	public String createProduct(Product product){
		String responseMessage = null;
		if(product != null) {
			responseMessage = String.format("This is the post and the object is: %s", product.toString());
		}
		return responseMessage;
	}
	
	
	public String updateProduct(Product product){
		String responseMessage = null;
		if (product != null) {
			responseMessage = String.format("This is the put and the object is: %s", product.toString());
		}
		return responseMessage;
	}
	
	
	public String deleteProduct(String productId){
		String responseMessage = null;
		responseMessage = String.format("Deleting license with id %s", productId);
		return responseMessage;
	}

}
