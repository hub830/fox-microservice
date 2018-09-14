package top.lemna.account.persistence.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAvailableBalanceLog is a Querydsl query type for AvailableBalanceLog
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAvailableBalanceLog extends EntityPathBase<AvailableBalanceLog> {

    private static final long serialVersionUID = -815040426L;

    public static final QAvailableBalanceLog availableBalanceLog = new QAvailableBalanceLog("availableBalanceLog");

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

    public QAvailableBalanceLog(String variable) {
        super(AvailableBalanceLog.class, forVariable(variable));
    }

    public QAvailableBalanceLog(Path<? extends AvailableBalanceLog> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAvailableBalanceLog(PathMetadata metadata) {
        super(AvailableBalanceLog.class, metadata);
    }

}

