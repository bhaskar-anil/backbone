package in.taskoo.backbone.location.dto;

import lombok.Data;

@Data
public class Location {
  private Long id;
  private Long gid;
  private String name;
  private String placeId;
  private Geometry geometry;
  private String vicinity;
}
