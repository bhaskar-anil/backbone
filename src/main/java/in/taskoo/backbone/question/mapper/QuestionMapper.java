package in.taskoo.backbone.question.mapper;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.ocpsoft.prettytime.PrettyTime;
import org.springframework.stereotype.Component;

import in.taskoo.backbone.question.dto.Question;
import in.taskoo.backbone.question.entity.QuestionEntity;
import in.taskoo.backbone.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class QuestionMapper {
  private final UserMapper userMapper;
  
  public Question toQuestion(QuestionEntity entity) {
    return new Question()
        .setId(entity.getId())
        .setQuestionText(entity.getQuestionText())
        .setPostedAt(entity.getPostedAt())
        .setParentId(Objects.nonNull(entity.getParent())
            ? Optional.of(entity.getParent().getId())
            : Optional.empty())
        .setUser(userMapper.toUser(entity.getUserEntity()))
        .setTaskId(entity.getTaskEntity().getId())
        .setPostedAtString(new PrettyTime()
            .format(Date.from(entity.getSysUpdateDateTime().atZone(ZoneId.systemDefault()).toInstant())));
  }

  public QuestionEntity toEntity(Question question) {
    return new QuestionEntity()
        .setQuestionText(question.getQuestionText());
  }
  public List<Question> toQuestions(List<QuestionEntity> entities) {
    return entities
        .stream()
        .map(e -> toQuestion(e))
        .collect(Collectors.toList());
  }

}
