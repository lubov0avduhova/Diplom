package diplom.controllers;

import diplom.exception.PictureNotFoundException;
import diplom.model.Picture;
import diplom.services.PictureService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/pictures")
@AllArgsConstructor
public class PictureController {

    private final PictureService pictureService;

    @PostMapping("/add_newPicture")
    public void addNewPicture(
            @RequestBody Picture request
    ) {
        pictureService.createPicture(new Picture(
                request.getUrl()));
    }

    @PostMapping("/update_picture")
    public void updatePicture(
            @RequestBody Picture request
    ) {
        pictureService.updatePicture(request.getId(), new Picture(
                request.getUrl()));
    }

    @PostMapping("/delete_picture/{pictureId}")
    public void deletePicture(
            @PathVariable Long giftId
    ) {
        pictureService.deletePicture(giftId);
    }

    @GetMapping("/pictures")
    public Iterable<Picture> getAllPictures(
            @RequestParam(required = false) Long id
    ) {
        if (id == null) {
            return pictureService.getAllPictures();
        } else {
            throw new PictureNotFoundException();
        }
    }

}

