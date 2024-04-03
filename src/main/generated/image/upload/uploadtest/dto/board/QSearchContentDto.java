package image.upload.uploadtest.dto.board;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * image.upload.uploadtest.dto.board.QSearchContentDto is a Querydsl Projection type for SearchContentDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QSearchContentDto extends ConstructorExpression<SearchContentDto> {

    private static final long serialVersionUID = 209679814L;

    public QSearchContentDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> title, com.querydsl.core.types.Expression<String> nickname, com.querydsl.core.types.Expression<java.time.LocalDateTime> createTime) {
        super(SearchContentDto.class, new Class<?>[]{long.class, String.class, String.class, java.time.LocalDateTime.class}, id, title, nickname, createTime);
    }

}

