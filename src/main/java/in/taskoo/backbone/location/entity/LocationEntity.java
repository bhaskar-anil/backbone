package in.taskoo.backbone.location.entity;

import in.taskoo.backbone.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class LocationEntity extends BaseEntity {
  private Long id;
}
