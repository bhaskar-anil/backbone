package in.taskoo.backbone.user.dto;

import javax.validation.constraints.Email;

import lombok.Data;

@Data
public class User {
  private Long id;
  private Long phone;
  @Email
  private String email;
  private String name;
  private String imageUrl;
}
