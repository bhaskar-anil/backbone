package in.taskoo.backbone.offer.comment.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import in.taskoo.backbone.common.annotation.ValidatedController;
import in.taskoo.backbone.common.dto.CreateResponse;
import in.taskoo.backbone.offer.comment.dto.Comment;
import in.taskoo.backbone.offer.comment.service.CommentService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@ValidatedController(value = "/{taskId/offers/{offerId}/comments")
public class CommentController {

  private final CommentService commentService;

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
  public CreateResponse comment(@Valid @RequestBody Comment comment) {
    return commentService.comment(comment);
  }
}
