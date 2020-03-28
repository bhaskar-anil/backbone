package in.taskoo.backbone.task.mapper;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import in.taskoo.backbone.common.dto.enums.BudgetType;
import in.taskoo.backbone.common.dto.enums.DueTimeType;
import in.taskoo.backbone.location.mapper.LocationMapper;
import in.taskoo.backbone.task.dto.Budget;
import in.taskoo.backbone.task.dto.TaskLite;
import in.taskoo.backbone.task.dto.enums.TaskStatus;
import in.taskoo.backbone.task.dto.enums.TaskType;
import in.taskoo.backbone.task.entity.TaskEntity;
import in.taskoo.backbone.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TaskMapper {

  private final UserMapper userMapper;
  private final LocationMapper locationMapper;

  public TaskEntity toEntity(TaskLite task) {
    return new TaskEntity()
        .setTitle(task.getTitle())
        .setDetails(task.getDetails())
        .setTaskType(task.getTaskType().getId())
        .setStatus(TaskStatus.CREATED.getId())
        .setLocationEntity(Objects.nonNull(task.getLocation()) 
            ? locationMapper.toLocationEntity(task.getLocation())
            : null) // location
        .setMustHaves(String.join(",", task.getMustHaves()))
        .setDueDate(task.getDueDate())
        .setDueTime(task.getDueTimeType().getId())
        .setBudgetType(task.getBudget().getType().getId())
        .setBudgetAmount(task.getBudget().getAmount())
        .setBudgetHours(task.getBudget().getHours())
        .setUserEntity(userMapper.toUserEntity(task.getUser())) // user
        .setCategory(task.getCategory());
  }

  public TaskLite toTask(TaskEntity taskEntity) {
    return new TaskLite()
        .setId(taskEntity.getId())
        .setTitle(taskEntity.getTitle())
        .setDetails(taskEntity.getDetails())
        .setTaskType(TaskType.toEnum(taskEntity.getTaskType()))
        .setTaskStatus(TaskStatus.toEnum(taskEntity.getStatus()))
        .setLocation(locationMapper.toLocation(taskEntity.getLocationEntity()))
        .setMustHaves(Arrays.asList(taskEntity.getMustHaves().split(",")))
        .setDueDate(taskEntity.getDueDate())
        .setDueTimeType(DueTimeType.toEnum(taskEntity.getDueTime()))
        .setBudget(new Budget()
            .setAmount(taskEntity.getBudgetAmount())
            .setHours(taskEntity.getBudgetHours())
            .setType(BudgetType.toEnum(taskEntity.getBudgetType())))
        .setUser(userMapper.toUser(taskEntity.getUserEntity()))
        .setCategory(taskEntity.getCategory())
        .setNoOfOffers(taskEntity.getNoOfOffers());
  }
  
  public List<TaskLite> toTaskLites(List<TaskEntity> entities) {
    return entities
        .stream()
        .map(entity -> toTask(entity))
        .collect(Collectors.toList());
  }
}
