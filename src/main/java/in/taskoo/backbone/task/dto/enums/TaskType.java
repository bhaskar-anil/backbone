package in.taskoo.backbone.task.dto.enums;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TaskType {
  IN_PERSON(1),
  REMOTE(2);

  private Integer id;

  @JsonCreator
  public static TaskType toEnum(Integer value) {
    return Arrays.stream(TaskType.values()).filter(type -> type.getId().equals(value)).findFirst().orElseThrow(null);
  }
}
