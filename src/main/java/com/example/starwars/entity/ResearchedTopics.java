package com.example.starwars.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Value;
import reactor.util.annotation.NonNull;

@Entity
public class ResearchedTopics implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @NotBlank(message = "O Tema não pode estar em branco")
  private String topics;

  //@NotBlank(message= "timeSearched não pode estar em branco")
  @Min(value = 1, message = "timeResearched não pode ser menor que 1")
  private Long timeSearched;

  public ResearchedTopics(String topics, Long timeSearched) {
    this.topics = topics;
    this.timeSearched = timeSearched;
  }

  public ResearchedTopics() {
  }

  public Long getId() {
    return id;
  }

  public void setTimeSearched(Long timeSearched) {
    this.timeSearched = timeSearched;
  }

  public String getTopics() {
    return topics;
  }

  public Long getTimeSearched() {
    return timeSearched;
  }

  public Long addTimesReserched(){
    Long times = this.getTimeSearched() + 1;
    return times;
  }
}
