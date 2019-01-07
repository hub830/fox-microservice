package top.lemna.product.persistence.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCategory is a Querydsl query type for Category
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCategory extends EntityPathBase<Category> {

    private static final long serialVersionUID = 1478765563L;

    public static final QCategory category = new QCategory("category");

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

    public final SetPath<CategoryProperties, QCategoryProperties> properties = this.<CategoryProperties, QCategoryProperties>createSet("properties", CategoryProperties.class, QCategoryProperties.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.util.Date> updatetime = _super.updatetime;

    public QCategory(String variable) {
        super(Category.class, forVariable(variable));
    }

    public QCategory(Path<? extends Category> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCategory(PathMetadata metadata) {
        super(Category.class, metadata);
    }

}

