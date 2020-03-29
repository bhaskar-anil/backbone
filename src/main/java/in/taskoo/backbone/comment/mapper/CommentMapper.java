package in.taskoo.backbone.comment.mapper;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.ocpsoft.prettytime.PrettyTime;
import org.springframework.stereotype.Component;

import in.taskoo.backbone.comment.dto.Comment;
import in.taskoo.backbone.comment.entity.CommentEntity;
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
        .setPostedAt(entity.getPostedAt())
        .setPostedAtString(new PrettyTime()
            .format(Date.from(entity.getSysUpdateDateTime().atZone(ZoneId.systemDefault()).toInstant())));
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
