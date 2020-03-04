package in.taskoo.backbone.offer.comment.dto;

import in.taskoo.backbone.common.dto.User;
import lombok.Data;

@Data
public class Comment {
  private Long id;
  private String comment;
  private User user;
}
