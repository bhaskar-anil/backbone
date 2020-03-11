package in.taskoo.backbone.offer.dto;

import java.util.List;

import in.taskoo.backbone.offer.comment.dto.Comment;
import in.taskoo.backbone.user.dto.User;
import lombok.Data;

@Data
public class Offer {
  private Long id;
  private User user;
  private Integer amount;
  private String details;
  private Long taskId;
  private List<Comment> comments;
}
