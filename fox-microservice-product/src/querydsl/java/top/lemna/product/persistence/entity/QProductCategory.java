package top.lemna.product.persistence.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProductCategory is a Querydsl query type for ProductCategory
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProductCategory extends EntityPathBase<ProductCategory> {

    private static final long serialVersionUID = 1246935408L;

    public static final QProductCategory productCategory = new QProductCategory("productCategory");

    public final top.lemna.product.persistence.entity.base.QAbstractDocument _super = new top.lemna.product.persistence.entity.base.QAbstractDocument(this);

    //inherited
    public final DateTimePath<java.util.Date> createtime = _super.createtime;

    public final StringPath describe = createString("describe");

    //inherited
    public final NumberPath<java.math.BigInteger> id = _super.id;

    public final StringPath name = createString("name");

    //inherited
    public final NumberPath<Integer> optimistic = _super.optimistic;

    public final NumberPath<Long> parentId = createNumber("parentId", Long.class);

    public final ListPath<ProductCategoryProperty, QProductCategoryProperty> properties = this.<ProductCategoryProperty, QProductCategoryProperty>createList("properties", ProductCategoryProperty.class, QProductCategoryProperty.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.util.Date> updatetime = _super.updatetime;

    public QProductCategory(String variable) {
        super(ProductCategory.class, forVariable(variable));
    }

    public QProductCategory(Path<? extends ProductCategory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProductCategory(PathMetadata metadata) {
        super(ProductCategory.class, metadata);
    }

}

