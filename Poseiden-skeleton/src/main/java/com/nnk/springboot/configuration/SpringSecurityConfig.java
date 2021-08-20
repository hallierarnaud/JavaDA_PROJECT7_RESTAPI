package com.nnk.springboot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
            .withUser("user").password(passwordEncoder().encode("$2a$10$pBV8ILO/s/nao4wVnGLrh.sa/rnr5pDpbeC4E.KNzQWoy8obFZdaa")).roles("USER")
            .and()
            .withUser("admin").password(passwordEncoder().encode("$2a$10$pBV8ILO/s/nao4wVnGLrh.sa/rnr5pDpbeC4E.KNzQWoy8obFZdaa")).roles("ADMIN", "USER");
  }

  @Override
  public void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
            .antMatchers("/admin").hasRole("ADMIN")
            .antMatchers("/user").hasRole("USER")
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .and()
            .oauth2Login();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
