package com.codegym.demo.service;

import com.codegym.demo.model.Product;
import com.codegym.demo.repository.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepo productRepo;

    @Override
    public ArrayList<Product> findAll() {
        return (ArrayList<Product>) productRepo.findAll();
    }
}
