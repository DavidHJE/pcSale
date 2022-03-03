package com.cda.pc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cda.pc.model.Computer;

@Repository
public interface ComputerRepository extends CrudRepository<Computer, Long>{

}
