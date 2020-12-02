package com.example.starwars.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class  People implements Serializable {

  String name;
  String height;
  String mass;
  String hair_color;
  String skin_color;
  String eye_color;
  String birthYear;
  String gender;
  String homeworld;
  List<String> films;
  List<String> species;
  List<String> vehicles;
  List<String> starships;
  String created;
  String edited;
  String url;

  public People() {
  }

  public String getName() {
    return name;
  }

  public String getHeight() {
    return height;
  }

  public String getMass() {
    return mass;
  }

  public String getHair_color() {
    return hair_color;
  }

  public String getSkin_color() {
    return skin_color;
  }

  public String getEye_color() {
    return eye_color;
  }

  public String getBirthYear() {
    return birthYear;
  }

  public String getGender() {
    return gender;
  }

  public String getHomeworld() {
    return homeworld;
  }

  public List<String> getFilms() {
    return films;
  }

  public List<String> getSpecies() {
    return species;
  }

  public List<String> getVehicles() {
    return vehicles;
  }

  public List<String> getStarships() {
    return starships;
  }

  public String getCreated() {
    return created;
  }

  public String getEdited() {
    return edited;
  }

  public String getUrl() {
    return url;
  }

  @Override
  public String toString() {
    return "People{" +
        "name='" + name + '\'' +
        ", height='" + height + '\'' +
        ", birthYear='" + birthYear + '\'' +
        ", films=" + films +
        '}';
  }

}
