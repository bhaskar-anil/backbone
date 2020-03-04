package in.taskoo.backbone.task.dto.enums;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TaskStatus {

  CREATED(1),
  OPEN(2),
  ACCEPTED(3),
  COMPLETED(4),
  CANCELLED(5),
  EXPIRED(6),
  CLOSED(7);

  private Integer id;

  @JsonCreator
  public static TaskStatus toEnum(Integer value) {
    return Arrays.stream(TaskStatus.values()).filter(type -> type.getId().equals(value)).findFirst().orElseThrow(null);
  }
}
