package diplom.controllers;


import diplom.exception.GiftNotFoundException;
import diplom.model.Gifts;
import diplom.services.GiftsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/gifts")
@AllArgsConstructor
public class GiftsController {

    private final GiftsService giftsService;


    @PostMapping("/add_newGift")
    public void addNewGift(
            @RequestBody Gifts request
    ) {
        giftsService.createGift(new Gifts(
                request.getId(),
                request.getShortName(),
                request.getDescription(),
                request.getPrice(),
                request.getPicture(),
                request.getUsersSex()));
    }

    @PostMapping("/update_gift")
    public void updateGift(
            @RequestBody Gifts request
    ) {
        giftsService.updateGift(request.getId(), new Gifts(
                request.getId(),
                request.getShortName(),
                request.getDescription(),
                request.getPrice(),
                request.getPicture(),
                request.getUsersSex()));
    }

    @PostMapping("/delete_gift/{giftId}")
    public void deleteGift(
            @PathVariable Long giftId
    ) {
        giftsService.deleteGift(giftId);
    }

    @GetMapping("/gifts")
    public Iterable<Gifts> getAllGifts(
            @RequestParam(required = false) Long id
    ) {
        if (id == null) {
            return giftsService.getAllGifts();
        } else {
            throw new GiftNotFoundException();
        }
    }

}
