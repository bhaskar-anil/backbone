package in.taskoo.backbone.category.dto;

import java.util.List;

import lombok.Data;

@Data
public class Category {
  private Long id;
  private String title;
  private List<String> tags;
}
