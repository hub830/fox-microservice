package top.lemna.product.persistence.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QProductProperty is a Querydsl query type for ProductProperty
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QProductProperty extends BeanPath<ProductProperty> {

    private static final long serialVersionUID = 203283015L;

    public static final QProductProperty productProperty = new QProductProperty("productProperty");

    public final StringPath optionName = createString("optionName");

    public final StringPath propertyName = createString("propertyName");

    public QProductProperty(String variable) {
        super(ProductProperty.class, forVariable(variable));
    }

    public QProductProperty(Path<? extends ProductProperty> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProductProperty(PathMetadata metadata) {
        super(ProductProperty.class, metadata);
    }

}

