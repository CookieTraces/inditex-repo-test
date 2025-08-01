package jose.zajara.inditex.infrastructure.repository;

import jose.zajara.inditex.application.port.PriceRepository;
import jose.zajara.inditex.domain.model.Price;
import jose.zajara.inditex.mapper.PriceMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PriceRepositoryImpl implements PriceRepository {

    private final JpaPriceRepository jpaPriceRepository;
    private final PriceMapper priceMapper;

    public PriceRepositoryImpl(JpaPriceRepository jpaPriceRepository, PriceMapper priceMapper) {
        this.jpaPriceRepository = jpaPriceRepository;
        this.priceMapper = priceMapper;
    }

    @Override
    public List<Price> findByProductIdAndBrandIdAndDate(Long productId, Long brandId, LocalDateTime date) {
        return jpaPriceRepository
                .findByProductIdAndBrandIdAndStartDateBeforeAndEndDateAfter(productId, brandId, date, date)
                .stream()
                .map(priceMapper::toDomain)
                .collect(Collectors.toList());
    }
}
