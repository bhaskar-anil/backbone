package in.taskoo.backbone.user.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import in.taskoo.backbone.user.dao.UserDao;
import in.taskoo.backbone.user.dto.User;
import lombok.RequiredArgsConstructor;

@Service(value = "userDetailsService")
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

  private final UserDao userDao;
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = (User) userDao.getUserByUsername(username);

    return new org.springframework.security.core.userdetails.User(username, user.getPassword(), getAuthority());
  }

  private List<SimpleGrantedAuthority> getAuthority() {
    return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
  }
}