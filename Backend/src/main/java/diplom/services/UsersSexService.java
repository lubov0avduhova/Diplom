package diplom.services;

import diplom.model.UsersSex;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import diplom.repository.UsersSexRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UsersSexService {

    private final UsersSexRepository usersSexRepository;

    public Iterable<UsersSex> getAllUsersSex() {
        return usersSexRepository.findAll();
    }

    public Optional<UsersSex> getUserSexById(Long id) {
        return usersSexRepository.findById(id);
    }

    public UsersSex createUserSex(UsersSex usersSex) {
        return usersSexRepository.save(usersSex);
    }

    public UsersSex updateUserSex(Long id, UsersSex userSexDetail) {
        Optional<UsersSex> optionalUsersSex = usersSexRepository.findById(id);
        if (optionalUsersSex.isPresent()) {
            UsersSex price = optionalUsersSex.get();
            price.setSex(userSexDetail.isSex());
            return usersSexRepository.save(price);
        } else {
            throw new IllegalArgumentException("UserSex not found with id: " + id);
        }
    }

    public void deleteUserSex(Long id) {
        usersSexRepository.deleteById(id);
    }
}


