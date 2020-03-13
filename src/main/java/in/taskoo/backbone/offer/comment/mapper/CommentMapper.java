package in.taskoo.backbone.offer.comment.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import in.taskoo.backbone.offer.comment.dto.Comment;
import in.taskoo.backbone.offer.comment.entity.CommentEntity;
import in.taskoo.backbone.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CommentMapper {
  private final UserMapper userMapper;
  
  public Comment toComment(CommentEntity entity) {
    return new Comment()
        .setComment(entity.getComment())
        .setId(entity.getId())
        .setUser(userMapper.toUser(entity.getUserEntity()))
        .setPostedAt(entity.getPostedAt());
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
