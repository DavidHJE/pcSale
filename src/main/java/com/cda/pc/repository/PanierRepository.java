package com.cda.pc.repository;

import org.springframework.data.repository.CrudRepository;


import com.cda.pc.model.User;

public interface PanierRepository extends CrudRepository<User, Long> {

}
