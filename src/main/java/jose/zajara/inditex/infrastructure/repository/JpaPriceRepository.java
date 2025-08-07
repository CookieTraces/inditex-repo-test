package jose.zajara.inditex.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface JpaPriceRepository extends JpaRepository<PriceEntity, Long> {

    @Query("""
        SELECT p FROM PriceEntity p 
        WHERE p.productId = :productId 
          AND p.brandId = :brandId 
          AND :date BETWEEN p.startDate AND p.endDate
        ORDER BY p.priority DESC
    """)
    List<PriceEntity> findValidPrices(Long productId, Long brandId, LocalDateTime date);
}
