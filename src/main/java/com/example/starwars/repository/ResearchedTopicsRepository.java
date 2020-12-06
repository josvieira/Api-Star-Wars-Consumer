package com.example.starwars.repository;

import com.example.starwars.entity.ResearchedTopics;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResearchedTopicsRepository extends JpaRepository<ResearchedTopics, Long> {
  Optional<ResearchedTopics> findByTopics(String topics);

  List<ResearchedTopics> findByOrderByTimeSearchedAsc();
}
