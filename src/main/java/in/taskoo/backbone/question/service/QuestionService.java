package in.taskoo.backbone.question.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import in.taskoo.backbone.common.dto.CreateResponse;
import in.taskoo.backbone.question.dto.Question;
import in.taskoo.backbone.question.entity.QuestionEntity;
import in.taskoo.backbone.question.repository.QuestionRepository;
import in.taskoo.backbone.task.entity.TaskEntity;
import in.taskoo.backbone.task.repository.TaskRepository;
import in.taskoo.backbone.user.entity.UserEntity;
import in.taskoo.backbone.user.repository.UserRepository;
import in.taskoo.common.exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuestionService {

  private final QuestionRepository questionRepository;
  private final UserRepository userRepository;
  private final TaskRepository taskRepository;

  public CreateResponse ask(@Valid Question question) {
    UserEntity userEntity = userRepository.findById(question.getUser().getId())
        .orElseThrow(() -> new DataNotFoundException(String.valueOf(question.getUser().getId())));
    TaskEntity taskEntity = taskRepository.findById(question.getTaskId())
        .orElseThrow(() -> new DataNotFoundException(String.valueOf(question.getTaskId())));
    QuestionEntity questionEntity = questionRepository.save(new QuestionEntity().
        setTaskEntity(taskEntity)
        .setUserEntity(userEntity)
        .setQuestion(question.getQuestion()));
    return new CreateResponse()
        .setId(questionEntity.getId());
  }

}
