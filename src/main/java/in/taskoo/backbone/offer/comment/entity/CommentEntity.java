package in.taskoo.backbone.offer.comment.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import in.taskoo.backbone.common.entity.BaseEntity;
import in.taskoo.backbone.common.entity.UserEntity;
import in.taskoo.backbone.offer.entity.OfferEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class CommentEntity extends BaseEntity {
  private Long id;
  private String comment;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private UserEntity userEntity;
  @ManyToOne
  @JoinColumn(name = "offer_id", referencedColumnName = "offer_id")
  private OfferEntity offerEntity;
}
