package com.example.starwars.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Planets {

  private List<String> residents;

  public Planets(List<String> residents) {
    this.residents = residents;
  }

  public Planets() {
  }

  public List<String> getResidents() {
    return residents;
  }

  @Override
  public String toString() {
    return "Planets{" +
        "residents=" + residents +
        '}';
  }
}
