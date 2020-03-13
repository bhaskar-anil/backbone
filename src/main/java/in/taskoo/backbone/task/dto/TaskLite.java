package in.taskoo.backbone.task.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import in.taskoo.backbone.common.dto.FileInfo;
import in.taskoo.backbone.common.dto.enums.DueTimeType;
import in.taskoo.backbone.location.dto.Location;
import in.taskoo.backbone.task.dto.enums.TaskStatus;
import in.taskoo.backbone.task.dto.enums.TaskType;
import in.taskoo.backbone.user.dto.User;
import lombok.Data;

@Data
public class TaskLite {
  private Long id;
  @NotBlank
  private String title;
  @NotBlank
  private String details;
  private TaskStatus taskStatus;
  private TaskType taskType;
  private List<String> mustHaves;
  @NotNull
  @Future
  @JsonFormat(pattern = "dd-MM-yyyy")
  private LocalDate dueDate;
  private DueTimeType dueTimeType;
  private Budget budget;
  private String category;
  @NotNull
  private Location location;
  private User user;
  private FileInfo fileInfo;
  @JsonProperty(access = Access.READ_ONLY)
  private Integer noOfOffers;
}
