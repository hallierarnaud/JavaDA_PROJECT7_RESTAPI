package com.nnk.springboot.controller;

import com.nnk.springboot.configuration.ApplicationSecurityTest;
import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;

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
public class CurveControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private CurvePointRepository curvePointRepository;

  @Test
  public void getCurve_shouldReturnOk() throws Exception {
    mockMvc.perform(get("/curvePoint/list")).andExpect(status().isOk());
  }

  @Test
  public void getCurveForm_shouldReturnOk() throws Exception {
    mockMvc.perform(get("/curvePoint/add")).andExpect(status().isOk());
  }

  @Test
  public void postCurve_shouldReturnOk() throws Exception {
    mockMvc.perform(post("/curvePoint/validate")
            .contentType(MediaType.APPLICATION_JSON).content("{}"))
            .andExpect(status().isOk());
  }

  @Test
  public void getUpdateForm_shouldReturnOk() throws Exception {
    when(curvePointRepository.findById(any())).thenReturn(java.util.Optional.of(new CurvePoint()));
    mockMvc.perform(get("/curvePoint/update/1")).andExpect(status().isOk());
  }

  /*@Test
  public void updateCurve_shouldReturnOk() throws Exception {
    when(curvePointRepository.save(any())).thenReturn(new CurvePoint());
    mockMvc.perform(post("/curvePoint/update/1")
            .contentType(MediaType.APPLICATION_JSON).content("{}"))
            .andExpect(status().isOk());
  }*/

  @Test
  public void deleteCurve_shouldReturnOk() throws Exception {
    when(curvePointRepository.findById(any())).thenReturn(java.util.Optional.of(new CurvePoint()));
    doNothing().when(curvePointRepository).delete(any());
    mockMvc.perform(get("/curvePoint/delete/1")).andExpect(status().isFound());
  }

}
