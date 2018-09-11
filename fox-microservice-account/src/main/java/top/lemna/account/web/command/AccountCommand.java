
package top.lemna.account.web.command;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;
import top.lemna.core.constraint.commons.LongSn;
import top.lemna.core.enums.commons.YesNo;
import top.lemna.core.validation.group.Add;

/**
 * 交易
 * 
 * @author hu
 *
 */
@Data
@NoArgsConstructor
public class AccountCommand {

//  @NotBlank(groups = {Update.class})
  @LongSn
  private Long id;

  @NotBlank(groups = {Add.class})
  @Size(min = 8, max = 64)
  String accountName;

  /** 锁定 */
  private YesNo block;

}
