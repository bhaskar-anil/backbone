package in.taskoo.backbone.task.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import in.taskoo.backbone.common.entity.BaseEntity;
import in.taskoo.backbone.common.entity.UserEntity;
import in.taskoo.backbone.location.entity.LocationEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class TaskEntity extends BaseEntity {
  private Long id;
  private String title;
  private String details;
  private Integer status;
  private Integer taskType;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "location_id", referencedColumnName = "id")
  private LocationEntity locationEntity;

  private String mustHaves;
  private LocalDate dueDate;
  private Integer dueTime;
  private Integer budgetType;
  private Integer budgetAmount;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "seeker_id", referencedColumnName = "id")
  private UserEntity userEntity;
  private String category;
}
