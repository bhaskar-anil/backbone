package in.taskoo.backbone.offer.comment.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import in.taskoo.backbone.common.dto.CreateResponse;
import in.taskoo.backbone.offer.comment.dto.Comment;
import in.taskoo.backbone.offer.comment.entity.CommentEntity;
import in.taskoo.backbone.offer.comment.repository.CommentRepository;
import in.taskoo.backbone.offer.entity.OfferEntity;
import in.taskoo.backbone.offer.repository.OfferRepository;
import in.taskoo.backbone.user.dto.User;
import in.taskoo.backbone.user.entity.UserEntity;
import in.taskoo.backbone.user.mapper.UserMapper;
import in.taskoo.backbone.user.repository.UserRepository;
import in.taskoo.common.exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {

  private final CommentRepository commentRepository;
  private final UserRepository userRepository;
  private final OfferRepository offerRepository;
  private final UserMapper userMapper;

  public CreateResponse comment(@Valid Comment comment) {
    User user = comment.getUser();
    OfferEntity offerEntity = offerRepository.findById(comment.getOfferId())
        .orElseThrow(() -> new DataNotFoundException("offer:" + comment.getOfferId()));
    UserEntity userEntity = userRepository
        .findByIdOrEmailOrPhone(user.getId(), user.getEmail(), user.getPhone())
        .stream()
        .findFirst()
        .orElse(userMapper.toUserEntity(user));
    CommentEntity commentEntity = commentRepository.save(new CommentEntity()
        .setComment(comment.getComment())
        .setUserEntity(userEntity))
        .setOfferEntity(offerEntity);
    return new CreateResponse()
        .setId(commentEntity.getId());
  }

}
