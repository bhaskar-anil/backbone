package in.taskoo.backbone.question.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import in.taskoo.backbone.user.dto.User;
import lombok.Data;

@Data
public class Question {
  private Long id;
  @NotNull
  @Valid
  private User user;
  @NotNull
  private Long taskId;
  @NotBlank
  private String questionText;
}
