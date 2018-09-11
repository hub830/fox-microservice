package top.lemna.account.persistence.entity.base;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@MappedSuperclass
@EqualsAndHashCode(callSuper=false)
public abstract class IdEntity  extends TimeEntity{
	private static final long serialVersionUID = 1L;

    /** 流水号 */
	@Id
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(length=32)
    private Long id;
 
}