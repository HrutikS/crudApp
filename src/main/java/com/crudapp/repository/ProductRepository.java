package com.crudapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudapp.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {   //Here, <Product,Integer> is <ModelName,DataTypeOfPrimaryKey> 

	Product findByName(String name);    //This method is created as we wanted to find product using the name parameter.

}
