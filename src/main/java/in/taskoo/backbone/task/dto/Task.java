package in.taskoo.backbone.task.dto;

import java.util.List;

import in.taskoo.backbone.offer.dto.Offer;
import in.taskoo.backbone.question.dto.Question;
import lombok.Data;

@Data
public class Task {
  private TaskLite taskLite;
  private List<Offer> offers;
  private List<Question> questions;
}
