package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Drug;
import com.demo.service.DrugService;

@RestController
@RequestMapping("/api/drug")
public class DrugController 
{
	@Autowired
	private DrugService drugService;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Drug> addDrug(@RequestBody Drug drug){
		Drug newdrug = drugService.addDrug(drug);
		return new ResponseEntity<Drug>(newdrug, HttpStatus.CREATED);
	}

	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<Drug> updateDrug(@RequestBody Drug drug){
		Drug newdrug = drugService.updateDrug(drug);
		return new ResponseEntity<Drug>(newdrug, HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value="/{drugid}", method=RequestMethod.DELETE)
	public ResponseEntity<Drug> deleteDrug(@PathVariable String drugid){
		drugService.deleteDrug(drugid);
		return new ResponseEntity<Drug>(HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Drug>> findAll(){
		return new ResponseEntity<List<Drug>>(drugService.findAll(), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(path="/{drugid}",method=RequestMethod.GET)
	public ResponseEntity<Drug> findOne(@PathVariable String drugid)
	{
		Drug drug = drugService.findDrug(drugid);
		return new ResponseEntity<Drug>(drug,HttpStatus.ACCEPTED);
	}
}
