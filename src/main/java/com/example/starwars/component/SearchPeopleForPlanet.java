package com.example.starwars.component;

import com.example.starwars.entity.People;
import com.example.starwars.entity.PeopleList;
import com.example.starwars.entity.Planets;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class SearchPeopleForPlanet {
//
//  @Autowired
//  private WebClient webClient; esse bean está dando conflito com o de people

  @Autowired
  private StarWars starWars;

  public Planets getPlanet(Long id){
    WebClient webClient = WebClient.create();
    return webClient
        .get()
        .uri( "https://swapi.dev/api/planets/{id}/", id)
        .retrieve()
        .bodyToMono(Planets.class)
        .block();
  }
  //Vou deixar definido que os personagens serão do mesmo planeta
  public List<People> filterPeople(People people) {
    List<People> peopleList = new ArrayList<>();
    /*
    * 1 - um personagem
    * 2 - pegar o planeta do personagem no atributo homeworld
    * 3 - fazer a chamada da api para o planeta
    * 4 - Pegar a lista de residentes no atributo residents de planet
    * 5 - Pegar três personagens e montar uma lista
    * */

    String[] uriPlanetSplit = people.getHomeworld().split("/");
    Planets planets = this.getPlanet(Long.valueOf(uriPlanetSplit[uriPlanetSplit.length-1]));

    peopleList.add(people);
    for (String iterator: planets.getResidents()) {
      if(!iterator.equals(people.getUrl())) {
        uriPlanetSplit = iterator.split("/");
        peopleList.add(starWars.getPeople(Long.valueOf(uriPlanetSplit[uriPlanetSplit.length-1])));
      }
      if (peopleList.size() >= 4)
        break;
    }

    return peopleList;
    //Não consegui utilizar esse código pois a chamada da api sem o s não funciona
//    Planets planets = this.getPlanet(people.getHomeworld());
//    for (int i =0; i<3; i++){
//      peopleList.add(starWars.getPeople(planets.getResidents().get(i)));
//    }
//    peopleList.add(people);
//    return peopleList;
  }
}
