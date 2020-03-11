package in.taskoo.backbone.task.service;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.stereotype.Service;

import in.taskoo.backbone.common.dto.CreateResponse;
import in.taskoo.backbone.task.dto.TaskLite;
import in.taskoo.backbone.task.entity.TaskEntity;
import in.taskoo.backbone.task.mapper.TaskMapper;
import in.taskoo.backbone.task.repository.TaskRepository;
import in.taskoo.backbone.user.dto.User;
import in.taskoo.backbone.user.entity.UserEntity;
import in.taskoo.backbone.user.mapper.UserMapper;
import in.taskoo.backbone.user.repository.UserRepository;
import in.taskoo.common.exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TaskService {

  private final TaskMapper taskMapper;
  private final TaskRepository taskRepository;
  private final UserRepository userRepository;
  private final UserMapper userMapper;

  @Transactional
  public CreateResponse postTask(@Valid TaskLite task) {
    User user = task.getUser();
    UserEntity userEntity = userRepository
        .findByIdOrEmailOrPhone(user.getId(), user.getEmail(), user.getPhone())
        .stream()
        .findFirst()
        .orElse(userMapper.toUserEntity(user));
    TaskEntity taskEntity = taskRepository.save(taskMapper.toEntity(task).setUserEntity(userEntity));
    return new CreateResponse().setId(taskEntity.getId());
  }

  public TaskLite getATaskById(Long taskId) {
    TaskEntity taskEntity = taskRepository.findById(taskId)
        .orElseThrow(() -> new DataNotFoundException(String.valueOf(taskId)));
    return taskMapper.toTask(taskEntity);
  }

}
