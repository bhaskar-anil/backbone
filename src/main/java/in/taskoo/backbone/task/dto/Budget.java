package in.taskoo.backbone.task.dto;

import javax.validation.constraints.Positive;

import in.taskoo.backbone.common.dto.enums.BudgetType;
import lombok.Data;

@Data
public class Budget {
  private BudgetType type;
  @Positive
  private Integer amount;
  private Integer hours;
}
