package top.lemna.account.persistence.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QWithDraw is a Querydsl query type for WithDraw
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QWithDraw extends EntityPathBase<WithDraw> {

    private static final long serialVersionUID = 2094629477L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QWithDraw withDraw = new QWithDraw("withDraw");

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

    public final EnumPath<top.lemna.core.enums.account.WithDrawType> type = createEnum("type", top.lemna.core.enums.account.WithDrawType.class);

    //inherited
    public final DateTimePath<java.util.Date> updatetime = _super.updatetime;

    public QWithDraw(String variable) {
        this(WithDraw.class, forVariable(variable), INITS);
    }

    public QWithDraw(Path<? extends WithDraw> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QWithDraw(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QWithDraw(PathMetadata metadata, PathInits inits) {
        this(WithDraw.class, metadata, inits);
    }

    public QWithDraw(Class<? extends WithDraw> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.trade = inits.isInitialized("trade") ? new QTrade(forProperty("trade")) : null;
    }

}

