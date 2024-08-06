package com.example.Ecomm.Services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.Ecomm.Model.Product;
import com.example.Ecomm.Repo.ProductRepo;

//@Service
//public class ProductService 
//{
//	@Autowired
//	private ProductRepo repo;
//	public List<Product> getAllProducts() 
//	{
//		List<Product> products = repo.findAll();
//        System.out.println("Products fetched from database: " + products);
//        return products;
//		 
//		//return repo.findAll();			//This returns the list of products
//		
//	}
//	
//
//}
@Service
public class ProductService {
    @Autowired
    private ProductRepo repo;

    public List<Product> getAllProducts() {
//        List<Product> products = repo.findAll();
//        System.out.println("Products fetched from database: " + products); // Log the retrieved data
//        if (products == null || products.isEmpty()) {
//            System.out.println("No products found in the database.");
//        }
        return repo.findAll();
    }
    
    public Product getProductByID(int id)
    {
    	return repo.findById(id).orElse(null);
    }

	public Product addProduct(Product product, MultipartFile imageFile) throws IOException 
	{
		product.setImageName(imageFile.getOriginalFilename());
		product.setImageType(imageFile.getContentType());
		product.setImageDate(imageFile.getBytes());
		return repo.save(product);
	}

	public Product updateProduct(int id, Product product, MultipartFile imageFile) throws IOException 
	{
		product.setImageDate(imageFile.getBytes());
		product.setImageName(imageFile.getOriginalFilename());
		product.setImageType(imageFile.getContentType());
		return repo.save(product);
		
	}

	public void deleteProduct(int id) 
	{
		repo.deleteById(id);
	}

	public List<Product> searchProducts(String keyword) 
	{
		return repo.searchProduct(keyword);
	}

	
}
