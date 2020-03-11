package in.taskoo.backbone.offer.mapper;

import org.springframework.stereotype.Component;

import in.taskoo.backbone.offer.dto.Offer;
import in.taskoo.backbone.offer.entity.OfferEntity;

@Component
public class OfferMapper {
  public OfferEntity toEntity(Offer offer) {
    return new OfferEntity()
        .setAmount(offer.getAmount())
        .setDetails(offer.getDetails());
  }
}
