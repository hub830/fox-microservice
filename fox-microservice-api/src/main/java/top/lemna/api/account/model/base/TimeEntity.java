package top.lemna.api.account.model.base;

import java.util.Date;
import lombok.Data;


@Data
public abstract class TimeEntity{
	/** 创建时间  */
	private Date createtime = new Date();
	/** 更新时间 */
	private Date updatetime;

}