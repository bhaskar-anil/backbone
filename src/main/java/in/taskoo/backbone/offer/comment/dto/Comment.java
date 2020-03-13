package in.taskoo.backbone.offer.comment.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import in.taskoo.backbone.user.dto.User;
import lombok.Data;

@Data
public class Comment {
  private Long id;
  @NotBlank
  private String comment;
  private Long offerId;
  private User user;

  @JsonProperty(access = Access.READ_ONLY)
  @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
  private LocalDateTime postedAt;
}
