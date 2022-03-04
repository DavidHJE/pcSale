package com.cda.pc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cda.pc.model.DetailModel;

@Repository
public interface DetailRepository extends CrudRepository<DetailModel, Long>{


}
