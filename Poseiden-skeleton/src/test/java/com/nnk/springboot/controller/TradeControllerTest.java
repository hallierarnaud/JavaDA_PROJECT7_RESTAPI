package com.nnk.springboot.controller;

import com.nnk.springboot.configuration.ApplicationSecurityTest;
import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;

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
public class TradeControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private TradeRepository tradeRepository;

  @Test
  public void getTrade_shouldReturnOk() throws Exception {
    mockMvc.perform(get("/trade/list")).andExpect(status().isOk());
  }

  @Test
  public void getTradeForm_shouldReturnOk() throws Exception {
    mockMvc.perform(get("/trade/add")).andExpect(status().isOk());
  }

  @Test
  public void postTrade_shouldReturnOk() throws Exception {
    mockMvc.perform(post("/trade/validate")
            .contentType(MediaType.APPLICATION_JSON).content("{}"))
            .andExpect(status().isOk());
  }

  @Test
  public void getUpdateForm_shouldReturnOk() throws Exception {
    when(tradeRepository.findById(any())).thenReturn(java.util.Optional.of(new Trade()));
    mockMvc.perform(get("/tradeList/update/1")).andExpect(status().isOk());
  }

  /*@Test
  public void updateTrade_shouldReturnOk() throws Exception {
    when(tradeRepository.save(any())).thenReturn(new Trade());
    mockMvc.perform(post("/trade/update/1")
            .contentType(MediaType.APPLICATION_JSON).content("{}"))
            .andExpect(status().isOk());
  }*/

  @Test
  public void deleteTrade_shouldReturnOk() throws Exception {
    when(tradeRepository.findById(any())).thenReturn(java.util.Optional.of(new Trade()));
    doNothing().when(tradeRepository).delete(any());
    mockMvc.perform(get("/tradeList/delete/1")).andExpect(status().isFound());
  }

}
