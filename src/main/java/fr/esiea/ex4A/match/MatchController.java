package fr.esiea.ex4A.match;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class MatchController {

    private final MatchRepository matchRepository;

    MatchController(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @GetMapping(path = "/api/matches", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> matches(@RequestParam @NonNull String userName, @RequestParam @NonNull String userCountry) {
        return ResponseEntity.ok("some matches");
    }
}
