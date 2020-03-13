package in.taskoo.backbone.offer.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import in.taskoo.backbone.common.dto.CreateResponse;
import in.taskoo.backbone.exception.InvalidTaskerException;
import in.taskoo.backbone.offer.dto.Offer;
import in.taskoo.backbone.offer.entity.OfferEntity;
import in.taskoo.backbone.offer.mapper.OfferMapper;
import in.taskoo.backbone.offer.repository.OfferRepository;
import in.taskoo.backbone.task.dto.enums.TaskStatus;
import in.taskoo.backbone.task.entity.TaskEntity;
import in.taskoo.backbone.task.repository.TaskRepository;
import in.taskoo.backbone.user.dto.User;
import in.taskoo.backbone.user.entity.UserEntity;
import in.taskoo.backbone.user.mapper.UserMapper;
import in.taskoo.backbone.user.repository.UserRepository;
import in.taskoo.common.exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OfferService {
  private final UserRepository userRepository;
  private final OfferRepository offerRepository;
  private final TaskRepository taskRepository;
  private final UserMapper userMapper;

  private final OfferMapper offerMapper;

  public CreateResponse offer(@Valid Offer offer) {
    TaskEntity taskEntity = taskRepository.findById(offer.getTaskId())
        .orElseThrow(() -> new DataNotFoundException("task", offer.getTaskId()));
    User user = offer.getUser();
    UserEntity userEntity = userRepository
        .findByIdOrEmailOrPhone(user.getId(), user.getEmail(), user.getPhone())
        .stream()
        .findFirst()
        .orElse(userMapper.toUserEntity(user));
    // user should be a valid tasker
    if (userEntity.getId().equals(taskEntity.getUserEntity().getId())) {
      throw new InvalidTaskerException("tasker and seeker can not be same");
    }
    OfferEntity offerEntity = offerRepository.save(offerMapper.toEntity(offer)
        .setUserEntity(userEntity)
        .setTaskEntity(taskEntity));
    return new CreateResponse().setId(offerEntity.getId());
  }

  public void accept(Long offerId) {
    OfferEntity offerEntity = offerRepository.findById(offerId)
        .orElseThrow(() -> new DataNotFoundException("offer", offerId));
    taskRepository.save(offerEntity.getTaskEntity().setStatus(TaskStatus.ACCEPTED.getId()));
  }

  public void withdraw(Long offerId) {
    OfferEntity offerEntity = offerRepository.findById(offerId)
        .orElseThrow(() -> new DataNotFoundException("offer", offerId));
    taskRepository.save(offerEntity.getTaskEntity().setStatus(TaskStatus.CANCELLED.getId()));
  }

}
