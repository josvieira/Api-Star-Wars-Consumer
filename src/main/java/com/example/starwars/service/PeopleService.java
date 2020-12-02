package com.example.starwars.service;


import com.example.starwars.component.StarWars;
import com.example.starwars.entity.People;
import com.example.starwars.entity.PeopleList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class PeopleService {

  @Autowired
  private StarWars starWars;


  public PeopleList getAllPeople() {

    return starWars.getAllPeople();
  }

  public People getPeople(Long id){

    return starWars.getPeople(id);
  }
}
