package com.example.starwars.controller;

import com.example.starwars.entity.People;
import com.example.starwars.entity.PeopleList;
import com.example.starwars.service.PeopleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/api/people")
@Api(value = "Api para consumir a API de People de Star War ")
public class PeopleController {

  @Autowired
  PeopleService peopleService;


  @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation("Retorna todos os personagens disponíveis na API de Star Wars")
  public PeopleList getAllPeople(){
    return peopleService.getAllPeople();
  }


  @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation("Retorna um único personagem, pasando um id")
  public List<People> getPeople(@PathVariable(value = "id") Long id){
    return peopleService.getPeople(id);
  }
}
