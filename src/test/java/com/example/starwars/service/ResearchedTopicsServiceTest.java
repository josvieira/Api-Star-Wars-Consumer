package com.example.starwars.service;

import static org.mockito.Mockito.when;

import com.example.starwars.entity.ResearchedTopics;
import com.example.starwars.repository.ResearchedTopicsRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@DisplayName("Testar a service ResearchedTopicsServices")
//@WebMvcTest(controllers = ResearchedTopicsService.class)
public class ResearchedTopicsServiceTest {

  @Autowired
  private ResearchedTopicsService service;

  @MockBean
  private ResearchedTopicsRepository repository;

  @Test
  @DisplayName("Testar o método getAll de ResearchedTopicsService")
  public void getAllSucessful(){
    //cenário: Uma lista de Researchedtopics com mais de um tema
    List<ResearchedTopics> topicsList = new ArrayList<>();
    ResearchedTopics topics = new ResearchedTopics("Planet", 1L);
    ResearchedTopics topics2 = new ResearchedTopics("People", 1L);
    topicsList.add(topics2);
    topicsList.add(topics);

    //Mocando o comportamento do repository
    Mockito.when(repository.findByOrderByTimeSearchedAsc()).thenReturn(topicsList);

    //Chamar o método da service
    List<ResearchedTopics> topicsResponse = this.service.getAll();

    //Verificar se o método do repository foi chamado
    Mockito.verify(repository).findByOrderByTimeSearchedAsc();

    //Verificar os resultados
    Assertions.assertEquals(2, topicsResponse.size());
  }


}
