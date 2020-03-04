package in.taskoo.backbone.offer.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import in.taskoo.backbone.common.dto.CreateResponse;
import in.taskoo.backbone.common.entity.UserEntity;
import in.taskoo.backbone.common.repository.UserRepository;
import in.taskoo.backbone.offer.dto.Offer;
import in.taskoo.backbone.offer.entity.OfferEntity;
import in.taskoo.backbone.offer.repository.OfferRepository;
import in.taskoo.backbone.task.entity.TaskEntity;
import in.taskoo.backbone.task.repository.TaskRepository;
import in.taskoo.common.exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OfferService {
  private final UserRepository userRepository;
  private final OfferRepository offerRepository;
  private final TaskRepository taskRepository;

  public CreateResponse offer(@Valid Offer offer) {
    TaskEntity taskEntity = taskRepository.findById(offer.getTaskId())
        .orElseThrow(() -> new DataNotFoundException(String.valueOf(offer.getUser().getId())));
    UserEntity userEntity = userRepository.findById(offer.getUser().getId())
        .orElseThrow(() -> new DataNotFoundException(String.valueOf(offer.getUser().getId())));
    OfferEntity offerEntity = offerRepository.save(new OfferEntity()
        .setUserEntity(userEntity)
        .setTaskEntity(taskEntity)
        .setAmount(offer.getAmount()));
    return new CreateResponse().setId(offerEntity.getId());
  }

}
