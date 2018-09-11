
package top.lemna.account.web.command;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import top.lemna.core.constraint.account.Amount;
import top.lemna.core.constraint.commons.LongSn;
import top.lemna.core.enums.account.RechargerType;
import top.lemna.core.validation.group.Add;
import top.lemna.core.validation.group.Update;

/**
 * 交易
 * 
 * @author hu
 *
 */
@Data
public class RechargCommand {

  @LongSn(groups = {Add.class,Update.class})
  private Long accountId;

  @Amount(groups = {Add.class})
  private Long amount;

  @NotNull(groups = {Add.class})
  private RechargerType type;

  @Size(max = 256)
  private String remark;
  
  

}
