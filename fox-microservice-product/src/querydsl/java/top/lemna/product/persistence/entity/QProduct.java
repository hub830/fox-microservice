package top.lemna.product.persistence.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProduct is a Querydsl query type for Product
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProduct extends EntityPathBase<Product> {

    private static final long serialVersionUID = -1925969326L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProduct product = new QProduct("product");

    public final top.lemna.product.persistence.entity.base.QAbstractDocument _super = new top.lemna.product.persistence.entity.base.QAbstractDocument(this);

    public final StringPath brief = createString("brief");

    public final QProductCarrier carrier;

    public final QProductCategory category;

    //inherited
    public final DateTimePath<java.util.Date> createtime = _super.createtime;

    public final StringPath describe = createString("describe");

    //inherited
    public final NumberPath<java.math.BigInteger> id = _super.id;

    public final StringPath name = createString("name");

    //inherited
    public final NumberPath<Integer> optimistic = _super.optimistic;

    public final StringPath productNo = createString("productNo");

    public final ListPath<ProductProperty, QProductProperty> properties = this.<ProductProperty, QProductProperty>createList("properties", ProductProperty.class, QProductProperty.class, PathInits.DIRECT2);

    public final EnumPath<top.lemna.core.enums.product.ProductStatus> status = createEnum("status", top.lemna.core.enums.product.ProductStatus.class);

    //inherited
    public final DateTimePath<java.util.Date> updatetime = _super.updatetime;

    public QProduct(String variable) {
        this(Product.class, forVariable(variable), INITS);
    }

    public QProduct(Path<? extends Product> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProduct(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProduct(PathMetadata metadata, PathInits inits) {
        this(Product.class, metadata, inits);
    }

    public QProduct(Class<? extends Product> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.carrier = inits.isInitialized("carrier") ? new QProductCarrier(forProperty("carrier")) : null;
        this.category = inits.isInitialized("category") ? new QProductCategory(forProperty("category")) : null;
    }

}

