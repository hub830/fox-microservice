package top.lemna.account.persistence.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRecharg is a Querydsl query type for Recharg
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRecharg extends EntityPathBase<Recharg> {

    private static final long serialVersionUID = 903207651L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRecharg recharg = new QRecharg("recharg");

    public final top.lemna.account.persistence.entity.base.QIdEntity _super = new top.lemna.account.persistence.entity.base.QIdEntity(this);

    public final NumberPath<Long> accountId = createNumber("accountId", Long.class);

    public final NumberPath<Long> amount = createNumber("amount", Long.class);

    //inherited
    public final DateTimePath<java.util.Date> createtime = _super.createtime;

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final NumberPath<Integer> optimistic = _super.optimistic;

    public final StringPath remark = createString("remark");

    public final QTrade trade;

    public final EnumPath<top.lemna.core.enums.account.RechargerType> type = createEnum("type", top.lemna.core.enums.account.RechargerType.class);

    //inherited
    public final DateTimePath<java.util.Date> updatetime = _super.updatetime;

    public QRecharg(String variable) {
        this(Recharg.class, forVariable(variable), INITS);
    }

    public QRecharg(Path<? extends Recharg> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRecharg(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRecharg(PathMetadata metadata, PathInits inits) {
        this(Recharg.class, metadata, inits);
    }

    public QRecharg(Class<? extends Recharg> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.trade = inits.isInitialized("trade") ? new QTrade(forProperty("trade")) : null;
    }

}

