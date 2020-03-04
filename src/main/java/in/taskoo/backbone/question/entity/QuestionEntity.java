package in.taskoo.backbone.question.entity;

import javax.persistence.Entity;

import in.taskoo.backbone.common.entity.BaseEntity;
import in.taskoo.backbone.common.entity.UserEntity;
import in.taskoo.backbone.task.entity.TaskEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class QuestionEntity extends BaseEntity {
  private Long id;
  private TaskEntity taskEntity;
  private UserEntity userEntity;
  private String question;
}
