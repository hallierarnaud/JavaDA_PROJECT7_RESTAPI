package com.nnk.springboot.configuration;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Order(1)
@TestConfiguration
public class ApplicationSecurityTest extends WebSecurityConfigurerAdapter {

  @Override
  public void configure (HttpSecurity httpSecurity) throws Exception {
    httpSecurity.csrf().disable().authorizeRequests().anyRequest().permitAll();
  }

}
