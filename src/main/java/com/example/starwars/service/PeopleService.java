package com.example.starwars.service;


import com.example.starwars.component.SearchPeopleForPlanet;
import com.example.starwars.component.StarWars;
import com.example.starwars.entity.People;
import com.example.starwars.entity.PeopleList;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeopleService {

  @Autowired
  private StarWars starWars;

  @Autowired
  private ResearchedTopicsService researchedTopicsService;

  @Autowired
  private SearchPeopleForPlanet searchPeopleForPlanet;


  public PeopleList getAllPeople() {
    researchedTopicsService.addTopics("people");//Deveria utilizar aqui um enum
    return starWars.getAllPeople();

  }

  public List<People> getPeople(Long id){
    researchedTopicsService.addTopics("people");

    People people = starWars.getPeople(id);
    List<People> peopleList = new ArrayList<>();
    if(people.getHomeworld().equals("")){
      peopleList.add(people);
      return peopleList;
    }
    else{
      peopleList = searchPeopleForPlanet.filterPeople(people);
      return peopleList;
    }
  }


}
