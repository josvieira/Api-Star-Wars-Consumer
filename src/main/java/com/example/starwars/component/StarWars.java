package com.example.starwars.component;

import com.example.starwars.entity.People;
import com.example.starwars.entity.PeopleList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class StarWars {

 @Autowired
 private WebClient webClient;


  public PeopleList getAllPeople(){
    return null;
  }

  public People getPeople(Long id) {

    return webClient
        .method(HttpMethod.GET)
        .uri("/{id}", id)
        .retrieve()
        .bodyToMono(People.class)
        .block();
  }

}
