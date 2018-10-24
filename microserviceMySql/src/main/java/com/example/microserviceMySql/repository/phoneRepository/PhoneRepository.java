package com.example.microserviceMySql.repository.phoneRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.microserviceMySql.model.phone.Phone;
@Repository
public interface PhoneRepository extends JpaRepository<Phone, Integer>{
	void deleteById(Integer id);
}
