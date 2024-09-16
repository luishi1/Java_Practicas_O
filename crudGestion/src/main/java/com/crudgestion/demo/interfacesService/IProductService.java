package com.crudgestion.demo.interfacesService;

import java.util.List;
import java.util.Optional;
import com.crudgestion.demo.model.Product;

public interface IProductService {
	public List<Product>list();
	public Optional<Product>listById(int id);
	public int save(Product p);
	public void delete(int id);
}