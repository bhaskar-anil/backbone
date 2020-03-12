package in.taskoo.backbone.offer.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import in.taskoo.backbone.common.entity.BaseEntity;
import in.taskoo.backbone.offer.comment.entity.CommentEntity;
import in.taskoo.backbone.task.entity.TaskEntity;
import in.taskoo.backbone.user.entity.UserEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Table(name = "t_offer")
@EqualsAndHashCode(callSuper = false)
public class OfferEntity extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @OneToOne
  @JoinColumn(name = "seeker_id", referencedColumnName = "id")
  private UserEntity userEntity;
  @OneToOne
  @JoinColumn(name = "task_id", referencedColumnName = "id")
  private TaskEntity taskEntity;
  @Column(name = "amount")
  private Integer amount;
  @Column(name = "details")
  private String details;
  @Column(name = "is_accepted")
  private Boolean isAccepted = Boolean.FALSE;
  @OneToMany(mappedBy = "offerEntity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<CommentEntity> comments;
}
