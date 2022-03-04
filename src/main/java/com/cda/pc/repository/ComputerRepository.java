package com.cda.pc.repository;

import org.springframework.data.repository.CrudRepository;
import com.cda.pc.model.Computer;

public interface ComputerRepository extends  CrudRepository<Computer, Long>{

}
