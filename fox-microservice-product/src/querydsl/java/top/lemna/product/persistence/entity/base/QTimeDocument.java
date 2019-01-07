package top.lemna.product.persistence.entity.base;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QTimeDocument is a Querydsl query type for TimeDocument
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QTimeDocument extends BeanPath<TimeDocument> {

    private static final long serialVersionUID = -253289240L;

    public static final QTimeDocument timeDocument = new QTimeDocument("timeDocument");

    public final DateTimePath<java.util.Date> createtime = createDateTime("createtime", java.util.Date.class);

    public final NumberPath<Integer> optimistic = createNumber("optimistic", Integer.class);

    public final DateTimePath<java.util.Date> updatetime = createDateTime("updatetime", java.util.Date.class);

    public QTimeDocument(String variable) {
        super(TimeDocument.class, forVariable(variable));
    }

    public QTimeDocument(Path<? extends TimeDocument> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTimeDocument(PathMetadata metadata) {
        super(TimeDocument.class, metadata);
    }

}

