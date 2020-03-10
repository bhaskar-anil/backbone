package in.taskoo.backbone.offer.comment.dto;

import javax.validation.constraints.NotBlank;

import in.taskoo.backbone.user.dto.User;
import lombok.Data;

@Data
public class Comment {
  private Long id;
  @NotBlank
  private String comment;
  private User user;
}
