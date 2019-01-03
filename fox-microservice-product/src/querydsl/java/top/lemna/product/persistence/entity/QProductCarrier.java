package top.lemna.product.persistence.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QProductCarrier is a Querydsl query type for ProductCarrier
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProductCarrier extends EntityPathBase<ProductCarrier> {

    private static final long serialVersionUID = -2039444410L;

    public static final QProductCarrier productCarrier = new QProductCarrier("productCarrier");

    public final top.lemna.product.persistence.entity.base.QAbstractDocument _super = new top.lemna.product.persistence.entity.base.QAbstractDocument(this);

    //inherited
    public final DateTimePath<java.util.Date> createtime = _super.createtime;

    public final StringPath describe = createString("describe");

    //inherited
    public final NumberPath<java.math.BigInteger> id = _super.id;

    public final StringPath name = createString("name");

    //inherited
    public final NumberPath<Integer> optimistic = _super.optimistic;

    //inherited
    public final DateTimePath<java.util.Date> updatetime = _super.updatetime;

    public QProductCarrier(String variable) {
        super(ProductCarrier.class, forVariable(variable));
    }

    public QProductCarrier(Path<? extends ProductCarrier> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProductCarrier(PathMetadata metadata) {
        super(ProductCarrier.class, metadata);
    }

}

