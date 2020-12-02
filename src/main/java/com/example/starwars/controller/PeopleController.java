package com.example.starwars.controller;

import com.example.starwars.entity.People;
import com.example.starwars.entity.PeopleList;
import com.example.starwars.service.PeopleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/api/people")
public class PeopleController {

  @Autowired
  PeopleService peopleService;

  @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
  public PeopleList getAllPeople(){
    return peopleService.getAllPeople();
  }

  @GetMapping("/{id}")
  public People getPeople(@PathVariable(value = "id") Long id){
    return peopleService.getPeople(id);
  }
}
