package com.codegym.demo.repository;

import com.codegym.demo.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface IProductRepo extends CrudRepository<Product,Long> {
}
