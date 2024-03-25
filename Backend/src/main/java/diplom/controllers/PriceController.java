package diplom.controllers;


import diplom.exception.PriceNotFoundException;
import diplom.model.Price;
import diplom.services.PriceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/price")
@AllArgsConstructor
public class PriceController {

    private final PriceService priceService;


    @PostMapping("/add_newPrice")
    public void addNewPrice(
            @RequestBody Price request
    ) {
        priceService.createPrice(new Price(
                request.getCost()));
    }

    @PostMapping("/update_price")
    public void updatePrice(
            @RequestBody Price request
    ) {
        priceService.updatePrice(request.getId(), new Price(
                request.getCost()));
    }

    @PostMapping("/delete_price/{priceId}")
    public void deletePrice(
            @PathVariable Long giftId
    ) {
        priceService.deletePrice(giftId);
    }

    @GetMapping("/prices")
    public Iterable<Price> getAllPrices(
            @RequestParam(required = false) Long id
    ) {
        if (id == null) {
            return priceService.getAllPrices();
        } else {
            throw new PriceNotFoundException();
        }
    }
}

