package com.nnk.springboot.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailService implements UserDetailsService {

  @Autowired
  private UserService userService;

  @Override
  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    if (userName.trim().isEmpty()) {
      throw new UsernameNotFoundException("username is empty");
    }
    User user = userService.findUserByUserName(userName);
    if (user == null) {
      throw new UsernameNotFoundException("User " + userName + " not found");
    }
    return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getGrantedAuthorities(user));

  }

  private List<GrantedAuthority> getGrantedAuthorities(User user) {
    List<GrantedAuthority> authorities = new ArrayList<>();
    String role = user.getRole();
    authorities.add(new SimpleGrantedAuthority(role));
    return authorities;
  }

}
