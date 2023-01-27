package com.hotel.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.app.dto.Employee;
import com.hotel.app.repo.DAO;

@RestController
@RequestMapping(path="/api/employees")
public class Controller{

    @Autowired
    DAO dao;

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable("id") String id){
        return dao.findById(id).orElse(null);
    }

    @GetMapping
    public List<Employee> getEmployees(){
        List<Employee> result = new ArrayList<>();
        dao.findAll().forEach(result::add);
        return result;
    }

    @PostMapping
    public Employee saveEmployee(@Validated @RequestBody Employee emp){

        return dao.save(emp);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable("id") String id){
        dao.deleteById(id);
    }

}
