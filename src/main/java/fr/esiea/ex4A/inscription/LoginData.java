package fr.esiea.ex4A.inscription;

import java.util.Objects;

public class LoginData {

    public final String userName;
    public final String userEmail;
    public final String userTweeter;
    public final String userCountry;
    public final String userSex;
    public final String userSexPref;

    public LoginData(String userName, String userEmail, String userTweeter, String userCountry,
                    String userSex, String userSexPref) {
        this.userName = userName;
        this.userTweeter = userTweeter;
        this.userCountry = userCountry;
        this.userSex = userSex;
        this.userSexPref = userSexPref;
        this.userEmail = userEmail;
    }

    public LoginData() {
        userName = null;
        userEmail = null;
        userTweeter = null;
        userCountry = null;
        userSex = null;
        userSexPref = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginData loginData = (LoginData) o;
        return Objects.equals(userName, loginData.userName) &&
            Objects.equals(userEmail, loginData.userEmail) &&
            Objects.equals(userTweeter, loginData.userTweeter) &&
            Objects.equals(userCountry, loginData.userCountry) &&
            Objects.equals(userSexPref, loginData.userSexPref);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, userEmail, userTweeter, userCountry, userSexPref);
    }
}
