package top.lemna.product.persistence.entity.base;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAbstractDocument is a Querydsl query type for AbstractDocument
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QAbstractDocument extends BeanPath<AbstractDocument> {

    private static final long serialVersionUID = -749034179L;

    public static final QAbstractDocument abstractDocument = new QAbstractDocument("abstractDocument");

    public final QTimeDocument _super = new QTimeDocument(this);

    //inherited
    public final DateTimePath<java.util.Date> createtime = _super.createtime;

    public final NumberPath<java.math.BigInteger> id = createNumber("id", java.math.BigInteger.class);

    //inherited
    public final NumberPath<Integer> optimistic = _super.optimistic;

    //inherited
    public final DateTimePath<java.util.Date> updatetime = _super.updatetime;

    public QAbstractDocument(String variable) {
        super(AbstractDocument.class, forVariable(variable));
    }

    public QAbstractDocument(Path<? extends AbstractDocument> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAbstractDocument(PathMetadata metadata) {
        super(AbstractDocument.class, metadata);
    }

}

