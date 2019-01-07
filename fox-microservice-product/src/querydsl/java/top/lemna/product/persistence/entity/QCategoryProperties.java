package top.lemna.product.persistence.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCategoryProperties is a Querydsl query type for CategoryProperties
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QCategoryProperties extends BeanPath<CategoryProperties> {

    private static final long serialVersionUID = 553981838L;

    public static final QCategoryProperties categoryProperties = new QCategoryProperties("categoryProperties");

    public final StringPath name = createString("name");

    public final SetPath<String, StringPath> options = this.<String, StringPath>createSet("options", String.class, StringPath.class, PathInits.DIRECT2);

    public QCategoryProperties(String variable) {
        super(CategoryProperties.class, forVariable(variable));
    }

    public QCategoryProperties(Path<? extends CategoryProperties> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCategoryProperties(PathMetadata metadata) {
        super(CategoryProperties.class, metadata);
    }

}

