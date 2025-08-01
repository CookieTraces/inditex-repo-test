package jose.zajara.inditex.mapper;

import jose.zajara.inditex.domain.model.Price;
import jose.zajara.inditex.infrastructure.repository.PriceEntity;
import org.springframework.stereotype.Component;

@Component
public class PriceMapper {
    public Price toDomain(PriceEntity entity) {
        return new Price(
                entity.getBrandId(),
                entity.getStartDate(),
                entity.getEndDate(),
                entity.getPriceList(),
                entity.getProductId(),
                entity.getPriority(),
                entity.getPrice(),
                entity.getCurrency()
        );
    }
}
