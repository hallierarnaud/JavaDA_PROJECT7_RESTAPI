package com.nnk.springboot.controller;

import com.nnk.springboot.configuration.ApplicationSecurityTest;
import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;

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
public class BidControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private BidListRepository bidListRepository;

  @Test
  public void getBid_shouldReturnOk() throws Exception {
    mockMvc.perform(get("/bidList/list")).andExpect(status().isOk());
  }

  @Test
  public void getBidForm_shouldReturnOk() throws Exception {
    mockMvc.perform(get("/bidList/add")).andExpect(status().isOk());
  }

  @Test
  public void postBid_shouldReturnOk() throws Exception {
    mockMvc.perform(post("/bidList/validate")
            .contentType(MediaType.APPLICATION_JSON).content("{}"))
            .andExpect(status().isOk());
  }

  @Test
  public void getUpdateForm_shouldReturnOk() throws Exception {
    when(bidListRepository.findById(any())).thenReturn(java.util.Optional.of(new BidList()));
    mockMvc.perform(get("/bidList/update/1")).andExpect(status().isOk());
  }

  @Test
  public void updateBid_shouldReturnOk() throws Exception {
    when(bidListRepository.save(any())).thenReturn(new BidList());
    mockMvc.perform(post("/bidList/update/1")
            .contentType(MediaType.APPLICATION_JSON).content("{}"))
            .andExpect(status().isOk());
  }

  @Test
  public void deleteBid_shouldReturnOk() throws Exception {
    when(bidListRepository.findById(any())).thenReturn(java.util.Optional.of(new BidList()));
    doNothing().when(bidListRepository).delete(any());
    mockMvc.perform(get("/bidList/delete/1")).andExpect(status().isFound());
  }

}
