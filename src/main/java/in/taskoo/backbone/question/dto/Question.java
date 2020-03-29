package in.taskoo.backbone.question.dto;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import in.taskoo.backbone.user.dto.User;
import lombok.Data;

@Data
public class Question {
  private Long id;
  private Optional<Long> parentId = Optional.empty();
  @NotNull
  @Valid
  private User user;
  @NotNull
  private Long taskId;
  @NotBlank
  private String questionText;

  @JsonProperty(access = Access.READ_ONLY)
  @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
  private LocalDateTime postedAt;
  private String postedAtString;
}
