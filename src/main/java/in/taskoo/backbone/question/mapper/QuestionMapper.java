package in.taskoo.backbone.question.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import in.taskoo.backbone.question.dto.Question;
import in.taskoo.backbone.question.entity.QuestionEntity;

@Component
public class QuestionMapper {
  public Question toQuestion(QuestionEntity entity) {
    return new Question()
        .setQuestionText(entity.getQuestionText());
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
