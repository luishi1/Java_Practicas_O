package com.crudgestion.demo.interfaces;

import com.crudgestion.demo.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProduct extends CrudRepository<Product, Integer>{

}