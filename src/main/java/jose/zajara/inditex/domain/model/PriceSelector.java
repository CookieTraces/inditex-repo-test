package jose.zajara.inditex.domain.model;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class PriceSelector {

    public static Optional<Price> selectApplicablePrice(List<Price> prices) {
        return prices.stream()
                .max(Comparator.comparingInt(Price::getPriority));
    }
}
