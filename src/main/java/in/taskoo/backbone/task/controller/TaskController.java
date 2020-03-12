package in.taskoo.backbone.task.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import in.taskoo.backbone.common.annotation.ValidatedController;
import in.taskoo.backbone.common.dto.CreateResponse;
import in.taskoo.backbone.task.dto.TaskLite;
import in.taskoo.backbone.task.service.TaskService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@ValidatedController(value = "/tasks")
public class TaskController {
  
  private final TaskService taskService;

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
  public CreateResponse postTask(@Valid @RequestBody TaskLite task) {
    return taskService.postTask(task);
  }

  @ResponseStatus(HttpStatus.FOUND)
  @GetMapping(path = "/{taskId}", produces = APPLICATION_JSON_VALUE)
  public Object getTaskLite(@PathVariable("taskId") Long taskId,
      @RequestParam(name = "complete", defaultValue = "false") Boolean complete) {
    return complete ? taskService.getTask(taskId) : taskService.getTaskLite(taskId);
  }
}
