package in.taskoo.backbone.question.entity;

import java.time.LocalDateTime;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import in.taskoo.backbone.common.entity.BaseEntity;
import in.taskoo.backbone.task.entity.TaskEntity;
import in.taskoo.backbone.user.entity.UserEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "t_question")
@Data
@EqualsAndHashCode(callSuper = false)
public class QuestionEntity extends BaseEntity {
  private static final long serialVersionUID = -8319589707663937039L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "question_text", columnDefinition = "TEXT")
  private String questionText;
  @Column(name = "posted_at")
  private LocalDateTime postedAt = LocalDateTime.now();

  @OneToOne
  @JoinColumn(name = "tasker_id", referencedColumnName = "id")
  private TaskEntity taskEntity;
  @OneToOne
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private UserEntity userEntity;

  @Basic(optional = true)
  @OneToOne
  @JoinColumn(name = "parent_id", referencedColumnName = "id")
  private QuestionEntity parent;
}
