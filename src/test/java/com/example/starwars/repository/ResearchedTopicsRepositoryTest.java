package com.example.starwars.repository;

import com.example.starwars.entity.ResearchedTopics;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@DisplayName("Teste unitário da classe ResearchedTopicsRepository")
public class ResearchedTopicsRepositoryTest {

  @Autowired
  private ResearchedTopicsRepository repository;

  @Test
  @DisplayName("Salva um tema, verifica: quantidade de registros e Id não nulo")
  public void savePersistTopicWhenSucesful(){
    ResearchedTopics topics = new ResearchedTopics("Planet", 1L);

    ResearchedTopics topics1 = repository.save(topics);
    Integer count = repository.findAll().size();

    Assertions.assertEquals(1, count);
    Assertions.assertNotNull(topics1.getId());
  }

  @Test
  @DisplayName("Atualizar a contagem de um tema ")
  public void updatTopicWhenSucesful(){
    ResearchedTopics topicSave = new ResearchedTopics("Planet", 1L);
    ResearchedTopics topicResponse = repository.save(topicSave);

    topicResponse.setTimeSearched(2L);
    ResearchedTopics topicResponse2 = repository.save(topicResponse);
    Integer count = repository.findAll().size();

    Assertions.assertNotNull(topicResponse2.getId());
    Assertions.assertEquals(topicResponse.getTopics(), topicResponse2.getTopics());
    Assertions.assertEquals(topicResponse.getId(), topicResponse2.getId());
    Assertions.assertEquals(2, topicResponse2.getTimeSearched());
    Assertions.assertEquals(1, count);

  }

  @Test
  @DisplayName("Buscar Tema por nome, verifica retorno não nulo e nome igual ao parâmetro")
  public void findByTopicsWhenSucessfull(){
    ResearchedTopics topics = new ResearchedTopics("Planet", 1L);
    repository.save(topics);

    Optional<ResearchedTopics> topicResponse = repository.findByTopics("Planet");

    Assertions.assertFalse(topicResponse.isEmpty());
    Assertions.assertEquals("Planet", topicResponse.get().getTopics());
  }

  @Test
  @DisplayName("Buscar tema, parametro de busca diferente do que foi salvo, deve retornar nulo")
  public  void findByTopicsWhenFailure(){
    ResearchedTopics topics = new ResearchedTopics("Planet", 1L);
    repository.save(topics);

    Optional<ResearchedTopics> topicResponse = repository.findByTopics("People");

    Assertions.assertTrue(topicResponse.isEmpty());
  }

  @Test
  @DisplayName("Salvar dois temas e verificar se o retorno é ordenado")
  public void findByOrderByTimeSearchedAscWhenSucessful(){
    //Cenário
    ResearchedTopics topics = new ResearchedTopics("Planet", 1L);
    repository.save(topics);
    ResearchedTopics topics2 = new ResearchedTopics("People", 2L);
    repository.save(topics2);

    List<ResearchedTopics> topicsList = repository.findByOrderByTimeSearchedAsc();
    //Validação
    Assertions.assertEquals(2,topicsList.size());
    Assertions.assertNotEquals("Planet", topicsList.get(1).getTopics());
  }

  @Test
  @DisplayName("Buscar todos os registros, retornar lista vazia")
  public void findAllWhenLisNull(){
    List<ResearchedTopics> listResponse = repository.findAll();

    //Verificar se lista está vazia e não nula
    Assertions.assertTrue(listResponse.isEmpty());
    Assertions.assertNotNull(listResponse);
  }
}
