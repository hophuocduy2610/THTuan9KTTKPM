package com.example.SpringRedisProject.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.SpringRedisProject.entity.Product;

@Repository
public class ProductRepository {
	public static final String HASH_KEY_NAME = "Product";

	@SuppressWarnings("rawtypes")
	
	@Autowired
	private RedisTemplate redisTemplate;

	@SuppressWarnings("unchecked")
	public Product save(Product product) {
		redisTemplate.opsForHash().put(HASH_KEY_NAME, product.getId(), product);
		return product;
	}

	@SuppressWarnings("unchecked")
	public List<Product> findAll() {
		return redisTemplate.opsForHash().values(HASH_KEY_NAME);
	}

	@SuppressWarnings("unchecked")
	public Product findProductByID(int id) {
		System.out.println(redisTemplate.opsForHash().get(HASH_KEY_NAME, id));
		return (Product) redisTemplate.opsForHash().get(HASH_KEY_NAME, id);
	}

	@SuppressWarnings("unchecked")
	public String deleteProduct(int id) {
		System.out.println(id);
		System.out.println(redisTemplate.opsForHash().delete(HASH_KEY_NAME, id));
		return "Delete success";
	}
}
