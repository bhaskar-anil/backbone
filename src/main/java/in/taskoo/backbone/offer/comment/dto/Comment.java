package in.taskoo.backbone.offer.comment.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import in.taskoo.backbone.user.dto.User;
import lombok.Data;

@Data
public class Comment {
  private Long id;
  @NotBlank
  private String comment;
  @NotNull
  private Long offerId;
  private User user;
}
