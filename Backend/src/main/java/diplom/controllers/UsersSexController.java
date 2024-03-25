package diplom.controllers;

import diplom.exception.UsersSexNotFoundException;
import diplom.model.UsersSex;
import diplom.services.UsersSexService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users_sex")
@AllArgsConstructor
public class UsersSexController {

    private final UsersSexService usersSexService;

    @GetMapping("/users_sex")
    public Iterable<UsersSex> getAllUsersSex(
            @RequestParam(required = false) Long id
    ) {
        if (id == null) {
            return usersSexService.getAllUsersSex();
        } else {
            throw new UsersSexNotFoundException();
        }
    }
}

