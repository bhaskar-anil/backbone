package in.taskoo.backbone.task.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

import in.taskoo.backbone.location.entity.LocationEntity;
import in.taskoo.backbone.offer.entity.OfferEntity;
import in.taskoo.backbone.question.entity.QuestionEntity;
import in.taskoo.backbone.user.entity.UserEntity;
import in.taskoo.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "t_task")
@Data
@EqualsAndHashCode(callSuper = false)
public class TaskEntity extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;
  @Column(name = "title")
  private String title;
  @Column(name = "details", columnDefinition = "TEXT")
  private String details;
  @Column(name = "status")
  private Integer status;
  @Column(name = "task_type")
  private Integer taskType;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "location_id", referencedColumnName = "id")
  private LocationEntity locationEntity;

  @Column(name = "must_haves")
  private String mustHaves;
  @Column(name = "due_date")
  private LocalDate dueDate;
  @Column(name = "due_time")
  private Integer dueTime;
  @Column(name = "budget_type")
  private Integer budgetType;
  @Column(name = "budget_amount")
  private Integer budgetAmount;
  @Column(name = "budget_hours")
  private Integer budgetHours;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "seeker_id", referencedColumnName = "id")
  private UserEntity userEntity;
  @Column(name = "category")
  private String category;

  @OneToMany(mappedBy = "taskEntity", cascade = CascadeType.ALL)
  private List<OfferEntity> offers;
  @OneToMany(mappedBy = "taskEntity", cascade = CascadeType.ALL)
  private List<QuestionEntity> questions;

  @Formula("(select count(*) from t_offer as of where of.task_id = id)")
  private Integer noOfOffers;
}
