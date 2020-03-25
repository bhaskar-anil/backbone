package in.taskoo.backbone.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import in.taskoo.backbone.user.dto.User;

@Component
public class UserDao {
  @Autowired
  @Qualifier("userApiTemplate")
  private RestTemplate userApiTemplate;
  
  @Value("${onboarding.url}")
  private String onboardingUrl;
  
  @Value("${onboarding.user.url}")
  private String userUrl;
  
  public User getUserByUsername(String username) {
    HttpHeaders headers = new HttpHeaders();
    UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(this.onboardingUrl)
                                          .path(this.userUrl)
                                          .queryParam("username", username);
    return userApiTemplate.exchange(uriBuilder.toUriString(), HttpMethod.GET, new HttpEntity<>(headers), User.class)
        .getBody();
  }
}
