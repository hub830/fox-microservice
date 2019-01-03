package top.lemna.user.persistence.entity;

import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.lemna.user.persistence.entity.base.AbstractDocument;

/**
 * 地址薄
 * 
 * @author toyota
 *
 */
@Data
@Document
@EqualsAndHashCode(callSuper = false)
public class AddressBook extends AbstractDocument {
  // 用户编号
  private Long userNo;

  // 地址本条数
  private int count;

  // 默认地址编号
  private Long defaultAddressNo;

  // 地址
  private List<Address> address;
}
