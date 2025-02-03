package com.unir.books.service;

import java.util.List;

import com.unir.books.data.model.Product;
import com.unir.books.controller.model.ProductDto;
import com.unir.books.controller.model.CreateProductRequest;

public interface ProductsService {
	
	List<Product> getProducts(String name, String country, String description, Boolean visible);
	
	Product getProduct(String productId);
	
	Boolean removeProduct(String productId);
	
	Product createProduct(CreateProductRequest request);

	Product updateProduct(String productId, String updateRequest);

	Product updateProduct(String productId, ProductDto updateRequest);

}
