package image.upload.uploadtest.dto.cart;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * image.upload.uploadtest.dto.cart.QGetCartDto is a Querydsl Projection type for GetCartDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QGetCartDto extends ConstructorExpression<GetCartDto> {

    private static final long serialVersionUID = -1727196441L;

    public QGetCartDto(com.querydsl.core.types.Expression<Long> cartId, com.querydsl.core.types.Expression<String> itemName, com.querydsl.core.types.Expression<Integer> price, com.querydsl.core.types.Expression<Integer> quantity, com.querydsl.core.types.Expression<Integer> total_price) {
        super(GetCartDto.class, new Class<?>[]{long.class, String.class, int.class, int.class, int.class}, cartId, itemName, price, quantity, total_price);
    }

}

