package top.lemna.user.persistence.entity;

import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.lemna.user.persistence.entity.base.AbstractDocument;

@Data
@Document
@EqualsAndHashCode(callSuper = true)
public class PrivilegeModule extends AbstractDocument {

  private String name;

  private String description;

  private List<Privilege> privileges;

  @Data
  public class Privilege {

    private String name;

    private String description;
  }
}
