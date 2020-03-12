package in.taskoo.backbone.offer.comment.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import in.taskoo.backbone.offer.comment.dto.Comment;
import in.taskoo.backbone.offer.comment.entity.CommentEntity;

@Component
public class CommentMapper {
  public Comment toComment(CommentEntity entity) {
    return new Comment()
        .setComment(entity.getComment());
  }
  
  public CommentEntity toEntity(Comment comment) {
    return new CommentEntity()
        .setComment(comment.getComment());
  }
  
  public List<Comment> toComments(List<CommentEntity> entities) {
    return entities
        .stream()
        .map(entity -> toComment(entity))
        .collect(Collectors.toList());
  }
}
