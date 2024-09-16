package com.crudgestion.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudgestion.demo.interfacesService.IProductService;
import com.crudgestion.demo.interfaces.IProduct;
import com.crudgestion.demo.model.Product;

@Service
public class ProductService implements IProductService{

	@Autowired
	private IProduct data;

	@Override
	public List<Product> list() {
		return (List<Product>)data.findAll();
	}

	@Override
	public Optional<Product> listById(int id) {
		return data.findById(id);
	}

	@Override
	public int save(Product p) {
		int response=0;
		Product product=data.save(p);
		if(!product.equals(null)) {
			response=1;
		}
		return response;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);
	}

}