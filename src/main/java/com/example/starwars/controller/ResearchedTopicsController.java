package com.example.starwars.controller;

import com.example.starwars.entity.ResearchedTopics;
import com.example.starwars.service.ResearchedTopicsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/topics")
@Api(value = "Api para mostrar o tema mais pesauidado da API de Star Wars")
public class ResearchedTopicsController {

  @Autowired
  private ResearchedTopicsService researchedTopicsService;


  @ApiOperation("Retorna todos os temas pesquisados da API de Star Wars")
  @GetMapping
  public ResponseEntity<List<ResearchedTopics>> getAllTopics(){
    return new ResponseEntity<>(researchedTopicsService.getAll(), HttpStatus.OK);
  }
}
