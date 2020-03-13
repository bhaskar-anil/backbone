package in.taskoo.backbone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "in.taskoo" })
public class BackboneApplication {

  public static void main(String[] args) {
    SpringApplication.run(BackboneApplication.class, args);
  }

}
