package com.nnk.springboot.controller;

import com.nnk.springboot.configuration.ApplicationSecurityTest;
import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationSecurityTest.class)
@AutoConfigureMockMvc
public class RatingControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private RatingRepository ratingRepository;

  @Test
  public void getRating_shouldReturnOk() throws Exception {
    mockMvc.perform(get("/rating/list")).andExpect(status().isOk());
  }

  @Test
  public void getRatingForm_shouldReturnOk() throws Exception {
    mockMvc.perform(get("/rating/add")).andExpect(status().isOk());
  }

  @Test
  public void postRating_shouldReturnOk() throws Exception {
    mockMvc.perform(post("/rating/validate")
            .contentType(MediaType.APPLICATION_JSON).content("{}"))
            .andExpect(status().isOk());
  }

  @Test
  public void getUpdateForm_shouldReturnOk() throws Exception {
    when(ratingRepository.findById(any())).thenReturn(java.util.Optional.of(new Rating()));
    mockMvc.perform(get("/rating/update/1")).andExpect(status().isOk());
  }

  @Test
  public void updateRating_shouldReturnOk() throws Exception {
    when(ratingRepository.save(any())).thenReturn(new Rating());
    mockMvc.perform(post("/rating/update/1")
            .contentType(MediaType.APPLICATION_JSON).content("{}"))
            .andExpect(status().isOk());
  }

  @Test
  public void deleteRating_shouldReturnOk() throws Exception {
    when(ratingRepository.findById(any())).thenReturn(java.util.Optional.of(new Rating()));
    doNothing().when(ratingRepository).delete(any());
    mockMvc.perform(get("/rating/delete/1")).andExpect(status().isFound());
  }

}
