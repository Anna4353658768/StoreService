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

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping(value="v1/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@GetMapping("/{productId}")
	public ResponseEntity<Product> getProduct(@PathVariable("productId") String productId) {
		
		Product product = productService.getProduct(productId);
		
		product.add(
				WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class)
						.getProduct(product.getId().toString())).withSelfRel(),
				
				WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class)
						.createProduct(product)).withRel("createProduct"),
				
				WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class)
						.updateProduct(product)).withRel("updateProduct"),
				
				WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class)
						.deleteProduct(product.getId().toString())).withRel("deleteProduct"));
		
		return ResponseEntity.ok(product);
	}
	
	
	@PutMapping
	public ResponseEntity<String> updateProduct(@RequestBody Product product) {
		return ResponseEntity.ok(productService.updateProduct(product));
	}
	
	
	@PostMapping
	public ResponseEntity<String> createProduct(@RequestBody Product product) {
		return ResponseEntity.ok(productService.createProduct(product));
	}
	
	
	@DeleteMapping(value="/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable("productId") String productId) {
		return ResponseEntity.ok(productService.deleteProduct(productId));
	}

}
