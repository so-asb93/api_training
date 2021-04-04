package fr.esiea.ex4A.service;

import fr.esiea.ex4A.client.AgifyApiData;
import fr.esiea.ex4A.client.AgifyClient;
import fr.esiea.ex4A.inscription.LoginData;
import fr.esiea.ex4A.inscription.LoginRepository;
import fr.esiea.ex4A.match.MatchData;
import fr.esiea.ex4A.match.MatchRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class MatcheService {

    private final AgifyClient agifyClient;
    private final LoginRepository loginRepository;
    private final MatchRepository matchRepository;

    public MatcheService(AgifyClient agifyClient, LoginRepository loginRepository, MatchRepository matchRepository) {
        this.agifyClient = agifyClient;
        this.loginRepository = loginRepository;
        this.matchRepository = matchRepository;
    }

    @Cacheable("UserData")
    public LoginData getUserAge(LoginData user) throws IOException {
        AgifyApiData apiUser = agifyClient.agePredict(user.userName, user.userCountry).execute().body();
        LoginData userCurrent = new LoginData(user.userName, user.userEmail, user.userTweeter, user.userCountry, user.userSex, user.userSexPref, apiUser.age);
        return userCurrent;
    }


    public ArrayList<MatchData> getMatches(String userName, String country_id) {
        LoginData user = loginRepository.getUserByNameAndCountry(userName, country_id);
        return (ArrayList<MatchData>) matchRepository.findMatch(user, country_id);
    }
}
