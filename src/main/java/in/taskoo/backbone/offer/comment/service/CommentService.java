package in.taskoo.backbone.offer.comment.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import in.taskoo.backbone.common.dto.CreateResponse;
import in.taskoo.backbone.common.entity.UserEntity;
import in.taskoo.backbone.common.repository.UserRepository;
import in.taskoo.backbone.offer.comment.dto.Comment;
import in.taskoo.backbone.offer.comment.entity.CommentEntity;
import in.taskoo.backbone.offer.comment.repository.CommentRepository;
import in.taskoo.common.exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {

  private final CommentRepository commentRepository;
  private final UserRepository userRepository;

  public CreateResponse comment(@Valid Comment comment) {
    UserEntity userEntity = userRepository.findById(comment.getUser().getId())
        .orElseThrow(() -> new DataNotFoundException(String.valueOf(comment.getUser().getId())));
    CommentEntity commentEntity = commentRepository.save(new CommentEntity()
        .setComment(comment.getComment())
        .setUserEntity(userEntity));
    return new CreateResponse()
        .setId(commentEntity.getId());
  }

}
