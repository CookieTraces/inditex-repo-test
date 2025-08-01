package jose.zajara.inditex.application.port;

import jose.zajara.inditex.domain.model.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository {
    List<Price> findByProductIdAndBrandIdAndDate(Long productId, Long brandId, LocalDateTime date);
}
