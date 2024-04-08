package image.upload.uploadtest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Pay {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderCode;
    private int totalPrice;
    private String paymentKey;

    public Pay(String orderCode, int totalPrice) {
        this.orderCode = orderCode;
        this.totalPrice = totalPrice;
    }

    public void changePaymentKey(String paymentKey){
        this.paymentKey = paymentKey;
    }
}
