package top.lemna.product.persistence.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QProductProperties is a Querydsl query type for ProductProperties
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QProductProperties extends BeanPath<ProductProperties> {

    private static final long serialVersionUID = 2081436965L;

    public static final QProductProperties productProperties = new QProductProperties("productProperties");

    public final StringPath optionName = createString("optionName");

    public final StringPath propertyName = createString("propertyName");

    public QProductProperties(String variable) {
        super(ProductProperties.class, forVariable(variable));
    }

    public QProductProperties(Path<? extends ProductProperties> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProductProperties(PathMetadata metadata) {
        super(ProductProperties.class, metadata);
    }

}

