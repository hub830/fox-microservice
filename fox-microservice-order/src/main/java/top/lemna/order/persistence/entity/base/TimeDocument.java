package top.lemna.order.persistence.entity.base;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.Version;

import lombok.Data;


@Data
public abstract class TimeDocument   {
    @Version
    private Integer optimistic;
	/** 创建时间  */
	private Date createtime = new Date();
	/** 更新时间 */
	private Date updatetime;

	public TimeDocument() {
		super();
	}

	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}