package image.upload.uploadtest.service.pay;

import image.upload.uploadtest.dto.pay.PrePaymentEntity;
import image.upload.uploadtest.entity.Pay;
import image.upload.uploadtest.repository.pay.PayRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class PayService {

    private final PayRepository payRepository;

    public Pay mount_prepare(PrePaymentEntity request) {

        Pay pay = new Pay(request.getOrderCode(), request.getTotalPrice());
        payRepository.save(pay);
        return pay;
    }

    public void setPaymentKey(String orderId, String paymentKey) {
        Pay findPay = payRepository.findByOrderCode(orderId);
        findPay.changePaymentKey(paymentKey);
    }
}
