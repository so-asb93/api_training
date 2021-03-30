package fr.esiea.ex4A.match;

import fr.esiea.ex4A.inscription.LoginData;
import fr.esiea.ex4A.inscription.LoginRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MatchRepository {
    public final LoginRepository loginRepository;

    public MatchRepository(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public List<MatchData> findMatch(LoginData user, String country_id) {
            List<MatchData> matches = new ArrayList<>();
            matches.add(new MatchData("machin", "machin45"));
            matches.add(new MatchData("truc", "trucbidule"));
            return matches;

    }
}
