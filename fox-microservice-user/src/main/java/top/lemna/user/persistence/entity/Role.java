package top.lemna.user.persistence.entity;

import java.util.Set;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.lemna.user.persistence.entity.base.TimeDocument;

@Data
@Document
@EqualsAndHashCode(callSuper = true)
public class Role extends TimeDocument {

  private String name;

  private String description;

  private Set<String> privileges;
}
