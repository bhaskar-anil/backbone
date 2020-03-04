package in.taskoo.backbone.common.entity;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class UserEntity extends BaseEntity {
  private Long id;
}
