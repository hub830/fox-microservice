package top.lemna.account.persistence.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QTrade is a Querydsl query type for Trade
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTrade extends EntityPathBase<Trade> {

    private static final long serialVersionUID = -390123511L;

    public static final QTrade trade = new QTrade("trade");

    public final top.lemna.account.persistence.entity.base.QIdEntity _super = new top.lemna.account.persistence.entity.base.QIdEntity(this);

    public final NumberPath<Long> accountId = createNumber("accountId", Long.class);

    //inherited
    public final DateTimePath<java.util.Date> createtime = _super.createtime;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final NumberPath<Long> income = createNumber("income", Long.class);

    //inherited
    public final NumberPath<Integer> optimistic = _super.optimistic;

    public final NumberPath<Long> outlay = createNumber("outlay", Long.class);

    public final StringPath remark = createString("remark");

    public final EnumPath<top.lemna.core.enums.account.BillStatus> status = createEnum("status", top.lemna.core.enums.account.BillStatus.class);

    public final StringPath tradeName = createString("tradeName");

    public final EnumPath<top.lemna.core.enums.account.BillType> type = createEnum("type", top.lemna.core.enums.account.BillType.class);

    //inherited
    public final DateTimePath<java.util.Date> updatetime = _super.updatetime;

    public QTrade(String variable) {
        super(Trade.class, forVariable(variable));
    }

    public QTrade(Path<? extends Trade> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTrade(PathMetadata metadata) {
        super(Trade.class, metadata);
    }

}

