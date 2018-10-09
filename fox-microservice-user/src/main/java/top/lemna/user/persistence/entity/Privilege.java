package top.lemna.user.persistence.entity;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.lemna.user.persistence.entity.base.AbstractDocument;

@Data
@Document
@EqualsAndHashCode(callSuper = true)
public class Privilege extends AbstractDocument {

  private String name;

  @Indexed(unique = true)
  private String operation;

  private String description;

  public Privilege(String name, String operation, String description) {
    super();
    this.name = name;
    this.operation = operation;
    this.description = description;
  }
}
