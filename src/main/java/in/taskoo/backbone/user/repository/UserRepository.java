package in.taskoo.backbone.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.taskoo.backbone.user.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
  List<UserEntity> findByIdOrEmailOrPhone(Long id, String email, String phone);
}
