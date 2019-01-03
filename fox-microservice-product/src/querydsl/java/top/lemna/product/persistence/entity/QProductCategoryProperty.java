package top.lemna.product.persistence.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProductCategoryProperty is a Querydsl query type for ProductCategoryProperty
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QProductCategoryProperty extends BeanPath<ProductCategoryProperty> {

    private static final long serialVersionUID = -215839899L;

    public static final QProductCategoryProperty productCategoryProperty = new QProductCategoryProperty("productCategoryProperty");

    public final StringPath name = createString("name");

    public final ListPath<ProductCategoryPropertyOption, SimplePath<ProductCategoryPropertyOption>> options = this.<ProductCategoryPropertyOption, SimplePath<ProductCategoryPropertyOption>>createList("options", ProductCategoryPropertyOption.class, SimplePath.class, PathInits.DIRECT2);

    public QProductCategoryProperty(String variable) {
        super(ProductCategoryProperty.class, forVariable(variable));
    }

    public QProductCategoryProperty(Path<? extends ProductCategoryProperty> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProductCategoryProperty(PathMetadata metadata) {
        super(ProductCategoryProperty.class, metadata);
    }

}

