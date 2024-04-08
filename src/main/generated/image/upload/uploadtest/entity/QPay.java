package image.upload.uploadtest.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPay is a Querydsl query type for Pay
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPay extends EntityPathBase<Pay> {

    private static final long serialVersionUID = -570044866L;

    public static final QPay pay = new QPay("pay");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath orderCode = createString("orderCode");

    public final StringPath paymentKey = createString("paymentKey");

    public final NumberPath<Integer> totalPrice = createNumber("totalPrice", Integer.class);

    public QPay(String variable) {
        super(Pay.class, forVariable(variable));
    }

    public QPay(Path<? extends Pay> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPay(PathMetadata metadata) {
        super(Pay.class, metadata);
    }

}

