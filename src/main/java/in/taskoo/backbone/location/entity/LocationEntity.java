package in.taskoo.backbone.location.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import in.taskoo.backbone.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "t_location")
@EqualsAndHashCode(callSuper = false)
public class LocationEntity extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "gid")
  private String gid; // id property from places api response
  @Column(name = "lng")
  private Double lng;
  @Column(name = "lat")
  private Double lat;
  @Column(name = "place_id")
  private String placeId;
  @Column(name = "name")
  private String name;
  @Column(name = "vicinity")
  private String vicinity;
}
