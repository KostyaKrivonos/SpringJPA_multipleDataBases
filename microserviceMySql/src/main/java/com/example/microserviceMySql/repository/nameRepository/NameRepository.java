package com.example.microserviceMySql.repository.nameRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.microserviceMySql.model.name.Name;
@Repository
public interface NameRepository extends JpaRepository<Name, Integer>{
	
	void deleteById(Integer id);
}
