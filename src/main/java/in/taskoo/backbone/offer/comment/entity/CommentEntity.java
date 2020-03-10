package in.taskoo.backbone.offer.comment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import in.taskoo.backbone.common.entity.BaseEntity;
import in.taskoo.backbone.offer.entity.OfferEntity;
import in.taskoo.backbone.user.entity.UserEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class CommentEntity extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "comment", columnDefinition = "TEXT")
  private String comment;
  @OneToOne
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private UserEntity userEntity;
  @ManyToOne
  @JoinColumn(name = "offer_id", referencedColumnName = "id")
  private OfferEntity offerEntity;
}
