package com.example.Ecomm.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Ecomm.Model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>		//This will take the class that i am working with and type of primary key as input
{
	@Query("SELECT p from Product p WHERE "+
			"LOWER(p.name) LIKE LOWER (CONCAT('%', :keyword, '%')) OR "+
			"LOWER(p.brand) LIKE LOWER (CONCAT('%', :keyword, '%')) OR "+ 
			"LOWER(p.category) LIKE LOWER (CONCAT('%', :keyword, '%'))")
	List<Product> searchProduct(String keyword);
	
	
	

}
