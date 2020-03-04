package in.taskoo.backbone.task.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Future;
import javax.validation.constraints.Positive;

import in.taskoo.backbone.common.dto.FileInfo;
import in.taskoo.backbone.common.dto.Location;
import in.taskoo.backbone.common.dto.User;
import in.taskoo.backbone.common.dto.enums.BudgetType;
import in.taskoo.backbone.common.dto.enums.DueTimeType;
import in.taskoo.backbone.task.dto.enums.TaskStatus;
import in.taskoo.backbone.task.dto.enums.TaskType;
import lombok.Data;

@Data
public class Task {
  private Long id;
  private String title;
  private String details;
  private TaskStatus taskStatus;
  private TaskType taskType;
  private List<String> mustHaves;
  @Future
  private LocalDate dueDate;
  private DueTimeType dueTimeType;
  private BudgetType budgetType;
  @Positive
  private Integer amount;
  private String category;
  private Location location;
  private User user;
  private FileInfo fileInfo;
}
