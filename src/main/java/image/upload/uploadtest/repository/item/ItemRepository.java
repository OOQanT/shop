package image.upload.uploadtest.repository.item;

import image.upload.uploadtest.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemRepository extends JpaRepository<Item,Long>, CustomItemRepository {

    @Query("SELECT COUNT(i) FROM Item i WHERE i.itemName LIKE %:itemName%")
    Long countByItemNameLike(@Param("itemName") String itemName);
}
