package in.taskoo.backbone.task.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import in.taskoo.backbone.common.dto.CreateResponse;
import in.taskoo.backbone.task.dto.TaskLite;
import in.taskoo.backbone.task.service.TaskService;
import in.taskoo.common.annotation.ValidatedController;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@ValidatedController
public class TaskController {
  
  private final TaskService taskService;

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(value = "/secure/tasks", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
  public CreateResponse postTask(@Valid @RequestBody TaskLite task) {
    return taskService.postTask(task);
  }

  @ResponseStatus(HttpStatus.FOUND)
  @GetMapping(path = "/tasks/{taskId}", produces = APPLICATION_JSON_VALUE)
  public Object getTaskLite(@PathVariable("taskId") Long taskId,
      @RequestParam(name = "complete", defaultValue = "false") Boolean complete) {
    return complete ? taskService.getTask(taskId) : taskService.getTaskLite(taskId);
  }

  // TODO later replace with search api
  @ResponseStatus(HttpStatus.FOUND)
  @GetMapping(path = "/tasks", produces = APPLICATION_JSON_VALUE)
  public List<TaskLite> findAll(@RequestParam(name = "q", required = false) String q,
      @RequestParam(name = "l", required = false) String l, @RequestParam(name = "maxp", required = false) Integer maxp,
      @RequestParam(name = "minp", required = false) Integer minp,
      @RequestParam(name = "tt", required = false) Integer tt,
      @RequestParam(name = "ts", required = false) Integer ts) {
    return taskService.search(q, l, maxp, minp, tt, ts);
  }
}
