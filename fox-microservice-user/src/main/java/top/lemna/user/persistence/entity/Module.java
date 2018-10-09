package top.lemna.user.persistence.entity;

import java.util.List;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.lemna.user.persistence.entity.base.AbstractDocument;

@Data
@Document
@EqualsAndHashCode(callSuper = true)
public class Module extends AbstractDocument {

  @Indexed(unique = true)
  private String name;

  private String description;

  @DBRef
  private List<Privilege> privileges;

  public Module(String name, String description) {
    super();
    this.name = name;
    this.description = description;
  }
}
