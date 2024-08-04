package com.example.Ecomm.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.Ecomm.Model.Product;
import com.example.Ecomm.Services.ProductService;

//@RestController
//@CrossOrigin
//@RequestMapping("/api")
//public class ProductController 
//{
//	@Autowired
//	private ProductService service;
//	@RequestMapping("/")
//	public String greet()
//	{
//		return "Hello rajath reigns";
//	}
//	
//	@GetMapping("/products")
//	public List<Product> getAllProducts()
//	{
//		System.out.println("Fetching all the records this is the controller");
//		return service.getAllProducts();
//	}
//
//}

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService service;


    @GetMapping("/products")
    public ResponseEntity< List<Product>> getAllProducts() {
        System.out.println("Fetching all products...");
        return new ResponseEntity<>( service.getAllProducts(), HttpStatus.OK);
    }
    
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable int id)
    {
    	Product product  = service.getProductByID(id);
    	if(product != null)
    	return new ResponseEntity<> (service.getProductByID(id), HttpStatus.OK);
    	else 
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Product product,
    									@RequestPart MultipartFile imageFile)			//@RequestBody will accept whole object or JSON as object but @RequestPart will accept it in parts
    {
    	try {
    		System.out.println(product);
    		Product product1 = service.addProduct(product, imageFile);
    		return new ResponseEntity<>(product1, HttpStatus.CREATED);
		} catch (Exception e) 
    	{
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
    	
    	
    }
	
}
