package in.taskoo.backbone.question.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import in.taskoo.backbone.common.annotation.ValidatedController;
import in.taskoo.backbone.common.dto.CreateResponse;
import in.taskoo.backbone.question.dto.Question;
import in.taskoo.backbone.question.service.QuestionService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@ValidatedController(value = "/questions")
public class QuestionController {
  
  private final QuestionService questionService;

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
  public CreateResponse ask(@Valid @RequestBody Question question) {
    return questionService.ask(question);
  }

}
