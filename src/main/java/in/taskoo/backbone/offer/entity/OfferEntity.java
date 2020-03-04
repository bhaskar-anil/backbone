package in.taskoo.backbone.offer.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import in.taskoo.backbone.common.entity.BaseEntity;
import in.taskoo.backbone.common.entity.UserEntity;
import in.taskoo.backbone.offer.comment.entity.CommentEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class OfferEntity extends BaseEntity {
  private Long id;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "seeker_id", referencedColumnName = "id")
  private UserEntity userEntity;
  private Integer amount;
  private Boolean isAccepted;
  @OneToMany(mappedBy = "offerEntity", cascade = CascadeType.ALL)
  private List<CommentEntity> comments;
}
