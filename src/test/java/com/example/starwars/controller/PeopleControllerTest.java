package com.example.starwars.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static reactor.core.publisher.Mono.when;

import com.example.starwars.entity.People;
import com.example.starwars.entity.PeopleList;
import com.example.starwars.service.PeopleService;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.ResultMatcher;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = PeopleController.class)
public class PeopleControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private PeopleService peopleService;

  @Test
  @DisplayName("Teste do método getAllPeople em caso de sucesso")
  public void getAllPepleSuccessful() throws Exception {
    PeopleList peopleList = new PeopleList();
    Mockito.when(peopleService.getAllPeople()).thenReturn(peopleList);
    mockMvc.perform(get("/api/people"))
            .andExpect(status().isOk());
  }

  @Test
  @DisplayName("Teste do método getPeople em caso de sucesso")
  public void getPepleSuccessful() throws Exception {
    List<People> people = new ArrayList<>();
    Mockito.when(peopleService.getPeople(1L)).thenReturn(people);// Não sei se faz muito sentido testar com esse mock
    mockMvc.perform(get("/api/people/1"))
        .andExpect(status().isOk());
  }


}
