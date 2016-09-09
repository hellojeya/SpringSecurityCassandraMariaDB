package com.demo.service;

import java.util.List;

import com.demo.model.Drug;

public interface DrugService 
{
	
	List<Drug> findAll();
	
	Drug findDrug(String drugid);
	
	Drug addDrug(Drug drug);
	
	Drug updateDrug(Drug drug);
	
	void deleteDrug(String drugid);
	
}
