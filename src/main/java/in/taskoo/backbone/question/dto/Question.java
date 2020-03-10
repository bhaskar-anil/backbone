package in.taskoo.backbone.question.dto;

import javax.validation.constraints.NotBlank;

import in.taskoo.backbone.user.dto.User;
import lombok.Data;

@Data
public class Question {
  private Long id;
  private User user;
  private Long taskId;
  @NotBlank
  private String question;
}
