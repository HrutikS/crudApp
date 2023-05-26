package com.crudapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudapp.entity.Product;
import com.crudapp.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public Product saveProduct(Product product) {
		return repository.save(product);
	}
	
	public List<Product> saveProducts(List<Product> products) {
		return repository.saveAll(products);
	}
	
	public List<Product> getProducts(){
		return repository.findAll();
	}
	
	public Product getProductById(int id){
		return repository.findById(id).orElse(null); //We are using the orElse method because otherwise it throws Optional error.
	}
	
	public Product getProductByName(String name){
		return repository.findByName(name);   //Here, findByName is not a standard method provided by JPARepo, so we created a method named findByName in ProductRepo.
	}
	
	public String deleteProductById(int id) {
		repository.deleteById(id);	
		return "Product with id"+id+"is deleted";
	}
	
	public Product updateProduct(Product product) {  //Since JPARepo does not provide update method, we have created this to update product.
		Product existingProduct = repository.findById(product.getId()).orElse(null); //Here we are creating a variable to make changes to, which we will replace with the existing one.
		existingProduct.setName(product.getName());									 //In the postman, we will send an Id, which will be fetched by this method and then changes will be made to that id's contents.
		existingProduct.setPrice(product.getPrice());
		existingProduct.setQuantity(product.getQuantity());
		return repository.save(existingProduct);
		
	}
}
