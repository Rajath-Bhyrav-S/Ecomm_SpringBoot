package com.example.Ecomm.Model;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product 
{
	@Id
	private int id;
	private String name;
	private String desc;
	private String brand;
	private BigDecimal price;
	private String category;
	private Date ReleaseDate;
	private boolean available;
	private int quantity;

}
