package com.example.starwars.component;

import com.example.starwars.entity.People;
import com.example.starwars.entity.Planets;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DisplayName("Testar a classe SearchPeopleForPlanetTest")
@SpringBootTest
public class SearchPeopleForPlanetTest {

  @Autowired
  private SearchPeopleForPlanet searchPeopleForPlanet;

  @Autowired
  private StarWars starWars;

  @Test
  @DisplayName("Testar o método getPlanet passando o planeta 1 e testando quem é o primeiro residente")
  public void getPlanetSucessful(){
    Planets planets = searchPeopleForPlanet.getPlanet(1L);

    Assertions.assertNotNull(planets);
    Assertions.assertEquals( "http://swapi.dev/api/people/1/", planets.getResidents().get(0));
  }

  @Test
  @DisplayName("Testar o método ")
  public void filterPeople(){
    People people = starWars.getPeople(1L);

    searchPeopleForPlanet.filterPeople(people);
  }
}
