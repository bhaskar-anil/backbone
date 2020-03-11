package in.taskoo.backbone.task.dto;

import java.util.List;

import in.taskoo.backbone.offer.dto.Offer;
import in.taskoo.backbone.question.dto.Question;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Task extends TaskLite {
  private List<Offer> offers;
  private List<Question> questions;
}
