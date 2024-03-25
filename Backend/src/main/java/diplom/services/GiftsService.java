package diplom.services;

import diplom.model.Gifts;
import diplom.repository.GiftsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GiftsService {
    private final GiftsRepository giftsRepository;

    public Iterable<Gifts> getAllGifts() {
        return giftsRepository.findAll();
    }

    public Optional<Gifts> getGiftById(Long id) {
        return giftsRepository.findById(id);
    }

    public Gifts createGift(Gifts gift) {
        return giftsRepository.save(gift);
    }

    public Gifts updateGift(Long id, Gifts giftsDetail) {
        Optional<Gifts> giftDetail = giftsRepository.findById(id);
        if (giftDetail.isPresent()) {
            Gifts gift = giftDetail.get();
            gift.setShortName(giftsDetail.getShortName());
            gift.setDescription(giftsDetail.getDescription());
            gift.setPrice(giftsDetail.getPrice());
            gift.setPicture(giftsDetail.getPicture());
            gift.setUsersSex(giftsDetail.getUsersSex());
            return giftsRepository.save(gift);
        } else {
            throw new IllegalArgumentException("Gift is not found with id: " + id);
        }
    }

    public void deleteGift(Long id) {
        giftsRepository.deleteById(id);
    }
}

