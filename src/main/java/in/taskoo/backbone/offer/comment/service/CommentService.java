package in.taskoo.backbone.offer.comment.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import in.taskoo.backbone.common.dto.CreateResponse;
import in.taskoo.backbone.offer.comment.dto.Comment;
import in.taskoo.backbone.offer.comment.entity.CommentEntity;
import in.taskoo.backbone.offer.comment.repository.CommentRepository;
import in.taskoo.backbone.offer.entity.OfferEntity;
import in.taskoo.backbone.offer.repository.OfferRepository;
import in.taskoo.backbone.user.entity.UserEntity;
import in.taskoo.backbone.user.service.UserService;
import in.taskoo.common.exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {

  private final CommentRepository commentRepository;
  private final OfferRepository offerRepository;
  private final UserService userService;

  public CreateResponse comment(@Valid Comment comment) {
    OfferEntity offerEntity = offerRepository.findById(comment.getOfferId())
        .orElseThrow(() -> new DataNotFoundException("offer:" + comment.getOfferId()));
    UserEntity userEntity = userService.findOrCreateNew(comment.getUser());
    CommentEntity commentEntity = new CommentEntity()
        .setComment(comment.getComment())
        .setUserEntity(userEntity)
        .setOfferEntity(offerEntity);
    commentRepository.save(commentEntity);
    return new CreateResponse()
        .setId(commentEntity.getId());
  }

}
