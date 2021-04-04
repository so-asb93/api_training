package fr.esiea.ex4A.inscription;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LoginRepository {

    public final List<LoginData> loginUsers = new ArrayList<>();

    public LoginData addUser(LoginData loginUser) {
        loginUsers.add(loginUser);
        return loginUser;
    }

    public boolean UserIsExist(LoginData loginUser) {
        return containsUser(loginUsers, loginUser);
    }

    private boolean containsUser(List<LoginData> loginUsers, LoginData userToCheck) {
        for (LoginData object : loginUsers) {
            if (object.equals(userToCheck))
                return true;
        }
        return false;
    }

    public LoginData getUserByNameAndCountry(String userName, String country) {
        for(LoginData u : loginUsers) {
            if (u.userCountry.equals(country) && u.userName.equals(userName)){
                return u;
            }
        }
        return null;
    }
}
