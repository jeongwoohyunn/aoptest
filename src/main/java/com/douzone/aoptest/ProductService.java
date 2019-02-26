package com.douzone.aoptest;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
	public ProductVo find(String name) {
		System.out.println("finding....");
		return new ProductVo(name);
	}
}
