package com.example.starwars.entity;

import java.util.List;

public class PeopleList {

  private Integer count;
  private String next;
  private String previous;
  private List<People> results;

  public PeopleList() {
  }

  @Override
  public String toString() {
    return "PeopleList{" +
        "count=" + count +
        ", next='" + next + '\'' +
        ", previous='" + previous + '\'' +
        ", results=" + results +
        '}';
  }

  public Integer getCount() {
    return count;
  }

  public String getNext() {
    return next;
  }

  public String getPrevious() {
    return previous;
  }

  public List<People> getResults() {
    return results;
  }
}
