package top.lemna.account.persistence.entity.base;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QTimeEntity is a Querydsl query type for TimeEntity
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QTimeEntity extends EntityPathBase<TimeEntity> {

    private static final long serialVersionUID = -1417967374L;

    public static final QTimeEntity timeEntity = new QTimeEntity("timeEntity");

    public final DateTimePath<java.util.Date> createtime = createDateTime("createtime", java.util.Date.class);

    public final NumberPath<Integer> optimistic = createNumber("optimistic", Integer.class);

    public final DateTimePath<java.util.Date> updatetime = createDateTime("updatetime", java.util.Date.class);

    public QTimeEntity(String variable) {
        super(TimeEntity.class, forVariable(variable));
    }

    public QTimeEntity(Path<? extends TimeEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTimeEntity(PathMetadata metadata) {
        super(TimeEntity.class, metadata);
    }

}

