package in.taskoo.backbone.common.dto.enums;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BudgetType {
  TOTAL(1),
  HOURLY(2);

  private Integer id;

  @JsonCreator
  public static BudgetType toEnum(Integer value) {
    return Arrays.stream(BudgetType.values()).filter(type -> type.getId().equals(value)).findFirst().orElseThrow(null);
  }
}
