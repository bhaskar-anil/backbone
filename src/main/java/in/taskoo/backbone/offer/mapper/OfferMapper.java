package in.taskoo.backbone.offer.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import in.taskoo.backbone.offer.comment.mapper.CommentMapper;
import in.taskoo.backbone.offer.dto.Offer;
import in.taskoo.backbone.offer.entity.OfferEntity;
import in.taskoo.backbone.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OfferMapper {
  private final UserMapper userMapper;
  private final CommentMapper commentMapper;
  
  public OfferEntity toEntity(Offer offer) {
    return new OfferEntity()
        .setAmount(offer.getAmount())
        .setDetails(offer.getDetails());
  }
  
  public Offer toOffer(OfferEntity offerEntity) {
    return new Offer()
        .setId(offerEntity.getId())
        .setAmount(offerEntity.getAmount())
        .setDetails(offerEntity.getDetails())
        .setUser(userMapper.toUser(offerEntity.getUserEntity()))
        .setComments(commentMapper.toComments(offerEntity.getComments()))
        .setTaskId(offerEntity.getTaskEntity().getId());
  }
  
  public List<Offer> toOffers(List<OfferEntity> entities) {
    return entities
        .stream()
        .map(entity -> toOffer(entity))
        .collect(Collectors.toList());
  }
 }
