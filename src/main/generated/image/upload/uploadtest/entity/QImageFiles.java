package image.upload.uploadtest.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QImageFiles is a Querydsl query type for ImageFiles
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QImageFiles extends EntityPathBase<ImageFiles> {

    private static final long serialVersionUID = 505237382L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QImageFiles imageFiles = new QImageFiles("imageFiles");

    public final QBoard board;

    public final DateTimePath<java.time.LocalDateTime> createTime = createDateTime("createTime", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath storeFilename = createString("storeFilename");

    public final DateTimePath<java.time.LocalDateTime> updateTime = createDateTime("updateTime", java.time.LocalDateTime.class);

    public final StringPath uploadFilename = createString("uploadFilename");

    public QImageFiles(String variable) {
        this(ImageFiles.class, forVariable(variable), INITS);
    }

    public QImageFiles(Path<? extends ImageFiles> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QImageFiles(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QImageFiles(PathMetadata metadata, PathInits inits) {
        this(ImageFiles.class, metadata, inits);
    }

    public QImageFiles(Class<? extends ImageFiles> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.board = inits.isInitialized("board") ? new QBoard(forProperty("board"), inits.get("board")) : null;
    }

}

