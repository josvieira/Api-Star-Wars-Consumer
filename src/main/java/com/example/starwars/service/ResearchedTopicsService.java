package com.example.starwars.service;

import com.example.starwars.entity.ResearchedTopics;
import com.example.starwars.repository.ResearchedTopicsRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ResearchedTopicsService {

  @Autowired
  private ResearchedTopicsRepository researchedTopicsRepository;


  public List<ResearchedTopics> getAll() {
    return this.researchedTopicsRepository.findByOrderByTimeSearchedAsc();
  }

  public void addTopics(String topics){
    Optional<ResearchedTopics> optionalTopics = researchedTopicsRepository.findByTopics(topics);
    if (!optionalTopics.isEmpty()){
      ResearchedTopics researchedTopics = optionalTopics.get();
      researchedTopics.setTimeSearched(researchedTopics.addTimesReserched());

      researchedTopicsRepository.save(researchedTopics);
    }
    else{
      ResearchedTopics researchedTopics = new ResearchedTopics(topics, 1L);
      researchedTopicsRepository.save(researchedTopics);
    }
  }
}
