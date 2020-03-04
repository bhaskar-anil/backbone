package in.taskoo.backbone.question.dto;

import in.taskoo.backbone.common.dto.User;
import lombok.Data;

@Data
public class Question {
  private Long id;
  private User user;
  private Long taskId;
  private String question;
}
