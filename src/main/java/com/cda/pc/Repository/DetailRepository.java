package com.cda.pc.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cda.pc.Models.DetailModel;

@Repository
public interface DetailRepository extends CrudRepository<DetailModel, Long>{

}
