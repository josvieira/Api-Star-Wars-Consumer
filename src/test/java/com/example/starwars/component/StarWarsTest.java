package com.example.starwars.component;

import com.example.starwars.entity.People;
import com.example.starwars.entity.PeopleList;
import javassist.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@ExtendWith(SpringExtension.class)
@DisplayName("Testar o consumo de API externa")
@SpringBootTest
public class StarWarsTest {
  
  @Autowired
  private StarWars starWars;
  
  @Test
  @DisplayName("Buscar todos os personagens, não retornar uma lista vazia")
  public void getAllPeopleSucessful(){
    PeopleList peopleList = starWars.getAllPeople();

    Assertions.assertNotNull(peopleList);
    Assertions.assertEquals("82", peopleList.getCount());
  }

  @Test
  @DisplayName("Buscar um personagem, verificar se o retorno não é nulo e o nome do personagem")
  public void getPeopleSuccessWhenIdExists(){
    People people = starWars.getPeople(1L);

    Assertions.assertNotNull(people);
    Assertions.assertEquals("Luke Skywalker", people.getName());
  }

  @Test
  @DisplayName("Buscar um personagem passando um id que não existe")
  public void getPeopleFailWhenIdNonExistent(){

    org.assertj.core.api.Assertions.assertThatExceptionOfType(WebClientResponseException.NotFound.class)
        .isThrownBy(()-> starWars.getPeople(0L));
  }

}
