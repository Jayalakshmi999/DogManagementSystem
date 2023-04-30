package com.example.DogManagementSystem.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.DogManagementSystem.models.Dog;
/*
 * @author Jaya Lakshmi Medikonda
 */

@Repository
public interface DogRepository extends CrudRepository<Dog,Integer>{



	List<Dog> findByName(String name);
	
}
