package in.taskoo.backbone.location.mapper;

import org.springframework.stereotype.Component;

import in.taskoo.backbone.location.dto.Geometry;
import in.taskoo.backbone.location.dto.Location;
import in.taskoo.backbone.location.entity.LocationEntity;

@Component
public class LocationMapper {
  public LocationEntity toLocationEntity(Location location) {
    return new LocationEntity()
        .setGid(location.getGid())
        .setLng(location.getGeometry().getLng())
        .setLat(location.getGeometry().getLat())
        .setName(location.getName())
        .setPlaceId(location.getPlaceId())
        .setVicinity(location.getVicinity());
  }

  public Location toLocation(LocationEntity locationEntity) {
    return new Location()
        .setId(locationEntity.getId())
        .setGid(locationEntity.getGid())
        .setGeometry(new Geometry().setLat(locationEntity.getLat())
            .setLng(locationEntity.getLng()))
        .setName(locationEntity.getName())
        .setPlaceId(locationEntity.getPlaceId())
        .setVicinity(locationEntity.getVicinity());
  }
}
