package com.hotel.app.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hotel.app.dto.Employee;

@Repository
public interface DAO extends CrudRepository<Employee,String>{
    
}
