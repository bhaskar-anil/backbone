package in.taskoo.backbone.common.dto.enums;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DueTimeType {
  MORNING(1),
  NOON(2),
  AFTERNOON(3),
  EVENING(4);

  private Integer id;

  @JsonCreator
  public static DueTimeType toEnum(Integer value) {
    return Arrays
        .stream(DueTimeType.values())
        .filter(type -> type.getId().equals(value))
        .findFirst()
        .orElseThrow(null);
  }
}
