package image.upload.uploadtest.dto.item;

import image.upload.uploadtest.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageDto {

    private Long id;
    private String itemName;
    private String seller;
    private int price;
    private int quantity;
    private String description;

    public PageDto(Item item){
        this.id = item.getId();
        this.itemName = item.getItemName();
        this.seller = item.getMember().getNickname();
        this.price = item.getPrice();
        this.quantity = item.getQuantity();
        this.description = item.getDescription();
    }

}
