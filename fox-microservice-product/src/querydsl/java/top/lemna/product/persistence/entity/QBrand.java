package top.lemna.product.persistence.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBrand is a Querydsl query type for Brand
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBrand extends EntityPathBase<Brand> {

    private static final long serialVersionUID = -412711510L;

    public static final QBrand brand = new QBrand("brand");

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

    public QBrand(String variable) {
        super(Brand.class, forVariable(variable));
    }

    public QBrand(Path<? extends Brand> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBrand(PathMetadata metadata) {
        super(Brand.class, metadata);
    }

}

