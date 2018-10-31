package top.lemna.api.account.model.base;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper=false)
public abstract class IdEntity  extends TimeEntity{
    private Long id;
 
}