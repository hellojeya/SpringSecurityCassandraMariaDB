package com.demo.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Drug;

@Repository
public interface DrugRepository extends CassandraRepository<Drug> {

}
