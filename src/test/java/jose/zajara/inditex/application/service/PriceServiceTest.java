package jose.zajara.inditex.application.service;

import jose.zajara.inditex.application.port.PriceRepository;
import jose.zajara.inditex.domain.model.Price;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class PriceServiceTest {

    private PriceRepository priceRepository;
    private PriceService priceService;

    @BeforeEach
    void setUp() {
        priceRepository = mock(PriceRepository.class);
        priceService = new PriceService(priceRepository);
    }

    @Test
    void shouldReturnHighestPriorityPrice_whenMultiplePricesAvailable() {
        Long productId = 35455L;
        Long brandId = 1L;
        LocalDateTime date = LocalDateTime.of(2020, 6, 14, 16, 0);

        Price lowPriority = new Price(brandId, date.minusHours(1), date.plusHours(1), 1, productId, 0, new BigDecimal("35.50"), "EUR");
        Price highPriority = new Price(brandId, date.minusHours(1), date.plusHours(1), 2, productId, 1, new BigDecimal("25.45"), "EUR");

        when(priceRepository.findByProductIdAndBrandIdAndDate(productId, brandId, date))
                .thenReturn(List.of(lowPriority, highPriority));

        Optional<Price> result = priceService.getApplicablePrice(productId, brandId, date);

        assertTrue(result.isPresent());
        assertEquals(2, result.get().getPriceList());
        assertEquals(new BigDecimal("25.45"), result.get().getPrice());
    }

    @Test
    void shouldReturnEmpty_whenNoPricesFound() {
        Long productId = 35455L;
        Long brandId = 1L;
        LocalDateTime date = LocalDateTime.of(2025, 1, 1, 0, 0);

        when(priceRepository.findByProductIdAndBrandIdAndDate(productId, brandId, date))
                .thenReturn(List.of());

        Optional<Price> result = priceService.getApplicablePrice(productId, brandId, date);

        assertTrue(result.isEmpty());
    }

    @Test
    void shouldHandleSingleMatchingPrice() {
        Long productId = 35455L;
        Long brandId = 1L;
        LocalDateTime date = LocalDateTime.of(2020, 6, 14, 10, 0);

        Price price = new Price(brandId, date.minusHours(1), date.plusHours(1), 1, productId, 0, new BigDecimal("35.50"), "EUR");

        when(priceRepository.findByProductIdAndBrandIdAndDate(productId, brandId, date))
                .thenReturn(List.of(price));

        Optional<Price> result = priceService.getApplicablePrice(productId, brandId, date);

        assertTrue(result.isPresent());
        assertEquals(1, result.get().getPriceList());
    }
}
