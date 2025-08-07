package jose.zajara.inditex.infrastructure.controller;

import jose.zajara.inditex.application.service.PriceService;
import jose.zajara.inditex.infrastructure.dto.PriceResponseDto;
import jose.zajara.inditex.mapper.PriceMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/prices")
public class PriceController {

    private final PriceService priceService;
    private final PriceMapper priceMapper;

    public PriceController(PriceService priceService, PriceMapper priceMapper) {
        this.priceService = priceService;
        this.priceMapper = priceMapper;
    }

    @GetMapping
    public ResponseEntity<PriceResponseDto> getPrice(
            @RequestParam Long productId,
            @RequestParam Long brandId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime applicationDate) {

        return priceService.getApplicablePrice(productId, brandId, applicationDate)
                .map(price -> ResponseEntity.ok(priceMapper.toResponse(price)))
                .orElse(ResponseEntity.notFound().build());
    }
}
