package diplom.services;

import diplom.model.Picture;
import diplom.repository.PictureRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PictureService {

    private final PictureRepository pictureRepository;
    public Iterable<Picture> getAllPictures() {
        return pictureRepository.findAll();
    }

    public Optional<Picture> getPictureById(Long id) {
        return pictureRepository.findById(id);
    }

    public Picture createPicture(Picture picture) {
        return pictureRepository.save(picture);
    }

    public Picture updatePicture(Long id, Picture pictureDetail) {
        Optional<Picture> optionalPicture = pictureRepository.findById(id);
        if (optionalPicture.isPresent()) {
            Picture picture = optionalPicture.get();
            picture.setUrl(pictureDetail.getUrl());
            return pictureRepository.save(picture);
        } else {
            throw new IllegalArgumentException("Picture not found with id: " + id);
        }
    }

    public void deletePicture(Long id) {
        pictureRepository.deleteById(id);
    }
}

