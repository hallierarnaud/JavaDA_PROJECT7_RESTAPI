package com.nnk.springboot.controller;

import com.nnk.springboot.configuration.ApplicationSecurityTest;
import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.BidListRepository;
import com.nnk.springboot.repositories.RuleNameRepository;

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
public class RuleControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private RuleNameRepository ruleNameRepository;

  @Test
  public void getRule_shouldReturnOk() throws Exception {
    mockMvc.perform(get("/ruleName/list")).andExpect(status().isOk());
  }

  @Test
  public void getRuleForm_shouldReturnOk() throws Exception {
    mockMvc.perform(get("/ruleName/add")).andExpect(status().isOk());
  }

  @Test
  public void postRule_shouldReturnOk() throws Exception {
    mockMvc.perform(post("/ruleName/validate")
            .contentType(MediaType.APPLICATION_JSON).content("{}"))
            .andExpect(status().isOk());
  }

  @Test
  public void getUpdateForm_shouldReturnOk() throws Exception {
    when(ruleNameRepository.findById(any())).thenReturn(java.util.Optional.of(new RuleName()));
    mockMvc.perform(get("/ruleName/update/1")).andExpect(status().isOk());
  }

  @Test
  public void updateRule_shouldReturnOk() throws Exception {
    when(ruleNameRepository.save(any())).thenReturn(new RuleName());
    mockMvc.perform(post("/ruleName/update/1")
            .contentType(MediaType.APPLICATION_JSON).content("{}"))
            .andExpect(status().isOk());
  }

  @Test
  public void deleteRule_shouldReturnOk() throws Exception {
    when(ruleNameRepository.findById(any())).thenReturn(java.util.Optional.of(new RuleName()));
    doNothing().when(ruleNameRepository).delete(any());
    mockMvc.perform(get("/ruleName/delete/1")).andExpect(status().isFound());
  }

}
