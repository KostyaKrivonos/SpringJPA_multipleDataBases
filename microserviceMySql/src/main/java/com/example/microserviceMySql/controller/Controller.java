package com.example.microserviceMySql.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.microserviceMySql.service.nameService.NameService;
import com.example.microserviceMySql.service.phoneService.PhoneService;
import com.example.microserviceMySql.dto.RequestDto;
import com.example.microserviceMySql.model.name.Name;
import com.example.microserviceMySql.model.phone.Phone;

@RestController
@RequestMapping("/mysql")
public class Controller {
	
	private NameService nameService;
	
	private PhoneService phoneService;
	@Autowired
	Controller(NameService nameService, PhoneService phoneService){
		this.nameService = nameService;
		this.phoneService = phoneService;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
	public void create(@RequestBody RequestDto name) {
		nameService.create(name.getName());
		phoneService.create(name.getPhone());
	}
	
	/*@RequestMapping(value = "/createName", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
	public void create(@Valid @RequestBody Name name) {
		nameService.create(name);
		//phoneService.create(phone);
	}
	
	@RequestMapping(value = "/createPhone", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
	public void create(@Valid @RequestBody Phone phone) {
		//nameService.create(name);
		phoneService.create(phone);
	}*/

	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Integer id) {
		nameService.deleteById(id);
		phoneService.deleteById(id);
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Name> get(@PathVariable("id") Integer id){
		Name name = nameService.getById(id);
		//Phone phone = phoneService.getById(id);
		return ResponseEntity.ok(name);
	}
}
