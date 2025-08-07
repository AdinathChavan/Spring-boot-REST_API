package com.webapp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.entity.ProductEntity;
import com.webapp.repository.ProductRepo;
import com.webapp.request.RequestDTO;

import jakarta.transaction.Transactional;

@Service
public class ProductService {

	@Autowired
	ProductRepo repository;
	
	public String add(RequestDTO data) {
		
		ProductEntity product = new ProductEntity();
		product.setId(data.getId());
		product.setName(data.getName());
		product.setPincode(data.getPincode());
		product.setPrice(data.getPrice());
		product.setAddress(data.getAddress());
		
		repository.save(product);
		
		return " Product Added successfully...";
		
	}
	
	public List<RequestDTO> getData(){
		
		List<ProductEntity> data = repository.findAll();
		
		List<RequestDTO> allData = data.stream().
				map(e->new RequestDTO(e.getId(),e.getName(),e.getPrice(),e.getAddress(),e.getPincode()))
						.collect(Collectors.toList());
						
						return allData;
	}

	public RequestDTO byId(int id) {
		Optional<ProductEntity> information = repository.findById(id);
		
		if(information.isPresent()) {
			ProductEntity data = information.get();
			RequestDTO product = new RequestDTO();
			
			product.setId(data.getId());
			product.setName(data.getName());
			product.setPincode(data.getPincode());
			product.setPrice(data.getPrice());
			product.setAddress(data.getAddress());
			
			return product; 
		}else {
			return null;
		}
		
		
	}

	public String  deleteById(int id) {
		
		if(repository.findById(id).isPresent()) {
			repository.deleteById(id);
			return "Product deleted successfully...";
		}
		else {
			return " Please enter valid Product id";
		}
		
		
		
	}

	
	@Transactional
	public String deleteByPincode(int pincode) {
		
		int result = repository.deleteByPincode(pincode);
		
		if(result>0) {
			return " product deleted successfully ";
		}
		else {
			return " enter valid Product Id ";
		}
	}

}
