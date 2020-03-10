package in.taskoo.backbone.user.dto;

import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class User {
  private Long id;
  private String userId;
  @Length(max = 10, min = 10)
  private String phone;
  @Email
  private String email;
  private String name;
  private String imageUrl;
}
