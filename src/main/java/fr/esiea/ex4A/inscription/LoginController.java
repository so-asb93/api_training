package fr.esiea.ex4A.inscription;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class LoginController {

    private final LoginRepository loginRepository;

    LoginController(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @PostMapping(path = "/api/inscription", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> inscription(@RequestBody LoginData loginUser) {
        if (!loginRepository.UserIsExist(loginUser)) {
            loginRepository.addUser(loginUser);
            return ResponseEntity.ok("User added");
        }
        return ResponseEntity.ok("User already exist");
    }
}
