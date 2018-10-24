package com.example.microserviceMySql.service.phoneService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.microserviceMySql.model.phone.Phone;
import com.example.microserviceMySql.repository.phoneRepository.PhoneRepository;

@Service
public class PhoneService {
	@Autowired
	private PhoneRepository phoneRepository;

	@Transactional
	public void create(String phone) {
		Phone phone1 = new Phone();
		phone1.setPhone(phone);
		phoneRepository.save(phone1);
	}

	@Transactional
	public void deleteById(Integer id) {
		phoneRepository.deleteById(id);
	}

	@Transactional
	public Phone getById(Integer id) {
		return phoneRepository.findById(id).get();
	}
}
