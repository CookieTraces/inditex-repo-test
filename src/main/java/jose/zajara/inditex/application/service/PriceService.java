package jose.zajara.inditex.application.service;

import jose.zajara.inditex.application.port.PriceRepository;
import jose.zajara.inditex.domain.model.Price;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Optional;

@Service
public class PriceService {

    private final PriceRepository priceRepository;

    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public Optional<Price> getApplicablePrice(Long productId, Long brandId, LocalDateTime date) {
        return priceRepository.findByProductIdAndBrandIdAndDate(productId, brandId, date).stream()
                .max(Comparator.comparingInt(Price::getPriority));
    }
}
