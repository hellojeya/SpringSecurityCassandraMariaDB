package com.demo.service;

import static org.springframework.data.cassandra.repository.support.BasicMapId.id;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.repository.MapId;
import org.springframework.stereotype.Service;

import com.demo.model.Drug;
import com.demo.repository.DrugRepository;

@Service
public class DrugServiceImpl implements DrugService {

	@Autowired
	private DrugRepository drugRepository;
	
	@Override
	public List<Drug> findAll() {
		// TODO Auto-generated method stub
		return (List<Drug>) drugRepository.findAll();
	}

	@Override
	public Drug findDrug(String drugid) {
		// TODO Auto-generated method stub
		MapId mapid=id("drugid",drugid);
		return drugRepository.findOne(mapid);
	}

	@Override
	public Drug addDrug(Drug drug) {
		// TODO Auto-generated method stub
		return  drugRepository.save(drug);
	}

	@Override
	public Drug updateDrug(Drug drug) {
		// TODO Auto-generated method stub
		return drugRepository.save(drug);
	}

	@Override
	public void deleteDrug(String drugid) {
		MapId mapid=id("drugid",drugid);
		// TODO Auto-generated method stub
		drugRepository.delete(mapid);
	}

}
