package in.taskoo.backbone.task.mapper;

import org.springframework.stereotype.Component;

import in.taskoo.backbone.common.dto.Location;
import in.taskoo.backbone.location.entity.LocationEntity;
import in.taskoo.backbone.task.dto.Task;
import in.taskoo.backbone.task.dto.enums.TaskStatus;
import in.taskoo.backbone.task.entity.TaskEntity;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TaskMapper {

  public TaskEntity toEntity(Task task) {
    return new TaskEntity()
        .setTitle(task.getTitle())
        .setDetails(task.getDetails())
        .setTaskType(task.getTaskType().getId())
        .setStatus(TaskStatus.CREATED.getId())
        .setLocationEntity(prepareLocationEntity(task.getLocation()))
        .setMustHaves(String.join(",", task.getMustHaves()))
        .setDueDate(task.getDueDate())
        .setBudgetType(task.getBudgetType().getId())
        .setBudgetAmount(task.getAmount())
        .setCategory(task.getCategory());
  }

  private LocationEntity prepareLocationEntity(Location location) {
    // TODO add other fields
    return new LocationEntity();
  }

}
