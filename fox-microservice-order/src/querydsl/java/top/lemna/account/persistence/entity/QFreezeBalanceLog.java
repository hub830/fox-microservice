package top.lemna.account.persistence.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QFreezeBalanceLog is a Querydsl query type for FreezeBalanceLog
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QFreezeBalanceLog extends EntityPathBase<FreezeBalanceLog> {

    private static final long serialVersionUID = 1449041146L;

    public static final QFreezeBalanceLog freezeBalanceLog = new QFreezeBalanceLog("freezeBalanceLog");

    public final top.lemna.account.persistence.entity.base.QIdEntity _super = new top.lemna.account.persistence.entity.base.QIdEntity(this);

    public final NumberPath<Long> accountId = createNumber("accountId", Long.class);

    public final NumberPath<Long> afterBalance = createNumber("afterBalance", Long.class);

    public final NumberPath<Long> beforeBalance = createNumber("beforeBalance", Long.class);

    //inherited
    public final DateTimePath<java.util.Date> createtime = _super.createtime;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final NumberPath<Integer> optimistic = _super.optimistic;

    public final NumberPath<Long> orderId = createNumber("orderId", Long.class);

    public final StringPath remark = createString("remark");

    //inherited
    public final DateTimePath<java.util.Date> updatetime = _super.updatetime;

    public QFreezeBalanceLog(String variable) {
        super(FreezeBalanceLog.class, forVariable(variable));
    }

    public QFreezeBalanceLog(Path<? extends FreezeBalanceLog> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFreezeBalanceLog(PathMetadata metadata) {
        super(FreezeBalanceLog.class, metadata);
    }

}

