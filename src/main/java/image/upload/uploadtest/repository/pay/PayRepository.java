package image.upload.uploadtest.repository.pay;

import image.upload.uploadtest.entity.Pay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayRepository extends JpaRepository<Pay,Long> {
    Pay findByOrderCode(String orderCode);
}
