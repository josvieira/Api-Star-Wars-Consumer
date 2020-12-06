package com.example.starwars.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class BeanConfiguration {

  /*Para o demais temas poderia criar outros beans ou deixar esse genérico e passar o
  /people na classe StarWars para o método correto*/

  @Bean
  public WebClient webClient(WebClient.Builder builder){
    return builder
        .baseUrl("https://swapi.dev/api")
        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .build();
  }
}
