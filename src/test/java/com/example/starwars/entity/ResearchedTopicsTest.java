package com.example.starwars.entity;

import javax.validation.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.assertj.core.api.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DisplayName("Testar a Classe ResearchedTopics")
public class ResearchedTopicsTest {

  @Test
  @DisplayName("Testar o método")
  public void addTimesResearchedSucesful(){
    ResearchedTopics researchedTopics = new ResearchedTopics("Films", 1L);

    Long timesResponse = researchedTopics.addTimesReserched();

    Assertions.assertNotNull(timesResponse);
    Assertions.assertEquals(2, timesResponse);
  }

  @Test
  @DisplayName("Testar o método com a classe instanciada mas não inicializada")
  public void addTimesResearchedFail() {
    ResearchedTopics researchedTopics = new ResearchedTopics();

    org.assertj.core.api.Assertions.assertThatExceptionOfType(NullPointerException.class)
        .isThrownBy(()-> researchedTopics.addTimesReserched());
  }

//  @Test
//  @DisplayName("Testar as constraints Validations do atributos")
//  public void researchedTopicsConstruct(){
//
//    ResearchedTopics researchedTopics = new ResearchedTopics();
//
//    org.assertj.core.api.Assertions.assertThatExceptionOfType(ConstraintViolationException.class)
//        .isThrownBy(()-> researchedTopics.setTimeSearched(0L))
//        .withMessageContaining("timeResearched não pode ser menor que 1");
//
//  }
}
