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
        ArrayList<MatchData> usersMatched = new ArrayList<>();
        if (loginRepository.loginUsers != null && loginRepository.loginUsers.size() > 1){
            for(LoginData u : loginRepository.loginUsers) {
                if (u.userSex.equals(user.userSexPref) && (Math.abs(u.userAge - user.userAge) <= 4) && !u.equals(user) && u.userCountry.equals(country_id)){
                    usersMatched.add(new MatchData(u.userName, u.userTweeter));
                }
            }
        }
        return usersMatched;
    }
}
