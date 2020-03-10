package in.taskoo.backbone.user.mapper;

import org.springframework.stereotype.Component;

import in.taskoo.backbone.user.dto.User;
import in.taskoo.backbone.user.entity.UserEntity;

@Component
public class UserMapper {
  public UserEntity toUserEntity(User user) {
    return new UserEntity()
        .setUserId(user.getUserId())
        .setEmail(user.getEmail())
        .setName(user.getName())
        .setImageUrl(user.getImageUrl())
        .setPhone(user.getPhone());
  }

  public User toUser(UserEntity userEntity) {
    return new User()
        .setId(userEntity.getId())
        .setName(userEntity.getName())
        .setEmail(userEntity.getEmail())
        .setImageUrl(userEntity.getImageUrl())
        .setPhone(userEntity.getPhone())
        .setUserId(userEntity.getUserId());
  }
}
