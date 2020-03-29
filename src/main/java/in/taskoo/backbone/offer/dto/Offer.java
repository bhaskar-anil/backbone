package in.taskoo.backbone.offer.dto;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import in.taskoo.backbone.comment.dto.Comment;
import in.taskoo.backbone.user.dto.User;
import lombok.Data;

@Data
public class Offer {
  private Long id;
  private User user;
  @Positive
  private Integer amount;
  private String details;
  @NotNull
  private Long taskId;
  private List<Comment> comments;
  private String postedAtString;
}
