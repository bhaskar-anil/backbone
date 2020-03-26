package in.taskoo.backbone.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import in.taskoo.backbone.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "t_user")
public class UserEntity extends BaseEntity {
  private static final long serialVersionUID = 155427850749407684L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;
  @Column(name = "user_id")
  private String userId; // this is the id of the user in on-boarding service
  @Column(name = "name")
  private String name;
  @Column(name = "email", unique = true)
  private String email;
  @Column(name = "image_url")
  private String imageUrl;
  @Column(name = "phone", unique = true)
  private String phone;
  @Column(name = "valid_tasker")
  private Boolean validTasker = Boolean.FALSE;
}
