package com.example.Ecomm.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Ecomm.Model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>		//This will take the class that i am working with and type of primary key as input
{
	

}
