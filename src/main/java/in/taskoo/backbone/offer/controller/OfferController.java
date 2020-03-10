package in.taskoo.backbone.offer.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import in.taskoo.backbone.common.annotation.ValidatedController;
import in.taskoo.backbone.common.dto.CreateResponse;
import in.taskoo.backbone.offer.dto.Offer;
import in.taskoo.backbone.offer.service.OfferService;
import lombok.RequiredArgsConstructor;

@ValidatedController(value = "/{taskId}/offers")
@RequiredArgsConstructor
public class OfferController {
  
  private final OfferService offerService;
  
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
  public CreateResponse offer(@Valid @RequestBody Offer offer) {
    return offerService.offer(offer);
  }

  @ResponseStatus(HttpStatus.OK)
  @PatchMapping(consumes = APPLICATION_JSON_VALUE, value = "/{offerId}/accept")
  public void accept(@PathVariable Long offerId) {
    offerService.accept(offerId);
  }
}
