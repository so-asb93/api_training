package fr.esiea.ex4A.inscription;

import fr.esiea.ex4A.service.MatcheService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class LoginController {

    private final LoginRepository loginRepository;
    private final MatcheService matcheService;

    LoginController(LoginRepository loginRepository, MatcheService matcheService) {
        this.loginRepository = loginRepository;
        this.matcheService = matcheService;
    }

    @PostMapping(path = "/api/inscription", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> inscription(@RequestBody LoginData loginUser) throws IOException {
        LoginData currentUser = matcheService.getUserAge(loginUser);
        if (!loginRepository.UserIsExist(currentUser)) {
            loginRepository.addUser(currentUser);
            return ResponseEntity.ok(currentUser);
        }
        return ResponseEntity.ok("User already exist");
    }
}
