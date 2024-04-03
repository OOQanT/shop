package image.upload.uploadtest.dto.item;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * image.upload.uploadtest.dto.item.QGetItemsDto is a Querydsl Projection type for GetItemsDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QGetItemsDto extends ConstructorExpression<GetItemsDto> {

    private static final long serialVersionUID = -984519126L;

    public QGetItemsDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> seller, com.querydsl.core.types.Expression<String> itemName, com.querydsl.core.types.Expression<Integer> price, com.querydsl.core.types.Expression<Integer> quantity, com.querydsl.core.types.Expression<Boolean> isFile) {
        super(GetItemsDto.class, new Class<?>[]{long.class, String.class, String.class, int.class, int.class, boolean.class}, id, seller, itemName, price, quantity, isFile);
    }

}

