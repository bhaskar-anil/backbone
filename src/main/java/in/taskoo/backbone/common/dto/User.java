package in.taskoo.backbone.common.dto;

import javax.validation.constraints.Email;

import lombok.Data;

@Data
public class User {
  private Long id;
  private Long mobileNumber;
  @Email
  private String email;
}
