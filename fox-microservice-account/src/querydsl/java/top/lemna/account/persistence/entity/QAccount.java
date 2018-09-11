package top.lemna.account.persistence.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAccount is a Querydsl query type for Account
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAccount extends EntityPathBase<Account> {

    private static final long serialVersionUID = -1356483694L;

    public static final QAccount account = new QAccount("account");

    public final top.lemna.account.persistence.entity.base.QIdEntity _super = new top.lemna.account.persistence.entity.base.QIdEntity(this);

    public final StringPath accountName = createString("accountName");

    public final NumberPath<Long> availableBalance = createNumber("availableBalance", Long.class);

    public final EnumPath<top.lemna.core.enums.commons.YesNo> block = createEnum("block", top.lemna.core.enums.commons.YesNo.class);

    //inherited
    public final DateTimePath<java.util.Date> createtime = _super.createtime;

    public final NumberPath<Long> freezeBalance = createNumber("freezeBalance", Long.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    //inherited
    public final NumberPath<Integer> optimistic = _super.optimistic;

    //inherited
    public final DateTimePath<java.util.Date> updatetime = _super.updatetime;

    public QAccount(String variable) {
        super(Account.class, forVariable(variable));
    }

    public QAccount(Path<? extends Account> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAccount(PathMetadata metadata) {
        super(Account.class, metadata);
    }

}

