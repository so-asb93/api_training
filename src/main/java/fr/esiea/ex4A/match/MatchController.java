package fr.esiea.ex4A.match;

import fr.esiea.ex4A.service.MatcheService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class MatchController {

    private final MatchRepository matchRepository;
    private final MatcheService matcheService;

    MatchController(MatchRepository matchRepository, MatcheService matcheService) {
        this.matchRepository = matchRepository;
        this.matcheService = matcheService;
    }

    @GetMapping(path = "/api/matches", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> matches(@RequestParam @NonNull String userName, @RequestParam @NonNull String userCountry) {
        return ResponseEntity.ok(matcheService.getMatches(userName, userCountry));
    }

}
