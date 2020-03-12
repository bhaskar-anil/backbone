package in.taskoo.backbone.user.service;

import org.springframework.stereotype.Service;

import in.taskoo.backbone.user.dto.User;
import in.taskoo.backbone.user.entity.UserEntity;
import in.taskoo.backbone.user.mapper.UserMapper;
import in.taskoo.backbone.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserMapper mapper;
  private final UserRepository repository;
  
  public UserEntity findOrCreateNew(User user) {
    return repository
        .findByIdOrEmailOrPhone(user.getId(), user.getEmail(), user.getPhone())
        .stream()
        .findFirst()
        .orElse(mapper.toUserEntity(user));
  }
}
