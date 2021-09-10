package com.nnk.springboot.controller;

import com.nnk.springboot.configuration.ApplicationSecurityTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationSecurityTest.class)
@AutoConfigureMockMvc
public class HomeControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void getHome_shouldReturnOk() throws Exception {
    mockMvc.perform(get("/")).andExpect(status().isOk());
  }

  @Test
  public void getAdminHome_shouldReturnOk() throws Exception {
    mockMvc.perform(get("/admin/home")).andExpect(status().isFound());
  }

}
