package com.nnk.springboot.controller;

import com.nnk.springboot.configuration.ApplicationSecurityTest;
import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.BidListRepository;
import com.nnk.springboot.repositories.UserRepository;

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
public class UserControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private UserRepository userRepository;

  @Test
  public void getUser_shouldReturnOk() throws Exception {
    mockMvc.perform(get("/user/list")).andExpect(status().isOk());
  }

  @Test
  public void getUserForm_shouldReturnOk() throws Exception {
    mockMvc.perform(get("/user/add")).andExpect(status().isOk());
  }

  @Test
  public void postUser_shouldReturnOk() throws Exception {
    mockMvc.perform(post("/user/validate")
            .contentType(MediaType.APPLICATION_JSON).content("{}"))
            .andExpect(status().isOk());
  }

  @Test
  public void getUpdateForm_shouldReturnOk() throws Exception {
    when(userRepository.findById(any())).thenReturn(java.util.Optional.of(new User()));
    mockMvc.perform(get("/user/update/1")).andExpect(status().isOk());
  }

  @Test
  public void updateUser_shouldReturnOk() throws Exception {
    when(userRepository.save(any())).thenReturn(new User());
    mockMvc.perform(post("/user/update/1")
            .contentType(MediaType.APPLICATION_JSON).content("{}"))
            .andExpect(status().isOk());
  }

  @Test
  public void deleteUser_shouldReturnOk() throws Exception {
    when(userRepository.findById(any())).thenReturn(java.util.Optional.of(new User()));
    doNothing().when(userRepository).delete(any());
    mockMvc.perform(get("/user/delete/1")).andExpect(status().isFound());
  }

}
