package image.upload.uploadtest.dto.item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageResponse<T> {
    private List<T> content;
    private int currentPage; //현재 페이지 번호
    private Long totalItems; // 전체 항목수
    private int totalPages;  // 전체 페이지 수

}
