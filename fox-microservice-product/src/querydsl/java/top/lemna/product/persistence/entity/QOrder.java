package top.lemna.product.persistence.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOrder is a Querydsl query type for Order
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOrder extends EntityPathBase<Order> {

    private static final long serialVersionUID = -400703119L;

    public static final QOrder order = new QOrder("order");

    public final top.lemna.product.persistence.entity.base.QAbstractDocument _super = new top.lemna.product.persistence.entity.base.QAbstractDocument(this);

    //inherited
    public final DateTimePath<java.util.Date> createtime = _super.createtime;

    //inherited
    public final NumberPath<java.math.BigInteger> id = _super.id;

    public final ListPath<OrderItem, QOrderItem> items = this.<OrderItem, QOrderItem>createList("items", OrderItem.class, QOrderItem.class, PathInits.DIRECT2);

    //inherited
    public final NumberPath<Integer> optimistic = _super.optimistic;

    public final NumberPath<Long> orderNo = createNumber("orderNo", Long.class);

    public final EnumPath<top.lemna.core.enums.product.OrderStatus> status = createEnum("status", top.lemna.core.enums.product.OrderStatus.class);

    public final NumberPath<Integer> totalMount = createNumber("totalMount", Integer.class);

    public final NumberPath<Integer> totalNumber = createNumber("totalNumber", Integer.class);

    //inherited
    public final DateTimePath<java.util.Date> updatetime = _super.updatetime;

    public final StringPath userName = createString("userName");

    public final NumberPath<Long> userNo = createNumber("userNo", Long.class);

    public QOrder(String variable) {
        super(Order.class, forVariable(variable));
    }

    public QOrder(Path<? extends Order> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOrder(PathMetadata metadata) {
        super(Order.class, metadata);
    }

}

