package com.devsuperior.bds02.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.repositories.CityRepository;

@Service
public class CityService {
	
	@Autowired
	private CityRepository repository;

	@Transactional(readOnly = true)
	public Page<CityDTO> findAll(PageRequest pageable) {
		Page<City> list = repository.findAll(pageable);

		return list.map(x -> new CityDTO(x));
	}

}
