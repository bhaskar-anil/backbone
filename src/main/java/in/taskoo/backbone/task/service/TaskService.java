package in.taskoo.backbone.task.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import in.taskoo.backbone.common.dto.CreateResponse;
import in.taskoo.backbone.common.entity.UserEntity;
import in.taskoo.backbone.common.repository.UserRepository;
import in.taskoo.backbone.task.dto.Task;
import in.taskoo.backbone.task.entity.TaskEntity;
import in.taskoo.backbone.task.mapper.TaskMapper;
import in.taskoo.backbone.task.repository.TaskRepository;
import in.taskoo.common.exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TaskService {

  private final TaskMapper taskMapper;
  private final TaskRepository taskRepository;
  private final UserRepository userRepository;

  public CreateResponse postTask(@Valid Task task) {
    UserEntity userEntity = userRepository.findById(task.getUser().getId())
        .orElseThrow(() -> new DataNotFoundException(String.valueOf(task.getUser().getId())));
    TaskEntity taskEntity = taskRepository.save(taskMapper.toEntity(task).setUserEntity(userEntity));
    return new CreateResponse().setId(taskEntity.getId());
  }

}
