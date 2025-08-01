package jose.zajara.inditex.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface JpaPriceRepository extends JpaRepository<PriceEntity, Long> {
    List<PriceEntity> findByProductIdAndBrandIdAndStartDateBeforeAndEndDateAfter(
            Long productId, Long brandId, LocalDateTime date1, LocalDateTime date2
    );
}
