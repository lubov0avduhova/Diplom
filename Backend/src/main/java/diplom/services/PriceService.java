package diplom.services;

import diplom.model.Price;
import diplom.repository.PriceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class PriceService {

    private final PriceRepository priceRepository;

    public Iterable<Price> getAllPrices() {
        return priceRepository.findAll();
    }

    public Optional<Price> getPriceById(Long id) {
        return priceRepository.findById(id);
    }

    public Price createPrice(Price price) {
        return priceRepository.save(price);
    }

    public Price updatePrice(Long id, Price priceDetail) {
        Optional<Price> optionalPrice = priceRepository.findById(id);
        if (optionalPrice.isPresent()) {
            Price price = optionalPrice.get();
            price.setCost(priceDetail.getCost());
            return priceRepository.save(price);
        } else {
            throw new IllegalArgumentException("Price not found with id: " + id);
        }
    }

    public void deletePrice(Long id) {
        priceRepository.deleteById(id);
    }
}

