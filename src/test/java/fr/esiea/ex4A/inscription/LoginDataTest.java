package fr.esiea.ex4A.inscription;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LoginDataTest {

    @Test
    void equality_between_two_users() {
        LoginData userOne = new LoginData("Toto", "toto@gmail.com", "totoTweet", "FR",
            "M", "F", 22);
        LoginData userTwo = new LoginData("Toto", "toto@gmail.com", "totoTweet", "FR",
            "M", "F", 22);

        Assertions.assertTrue(userOne.equals(userTwo) && userTwo.equals(userOne));
        Assertions.assertTrue(userOne.hashCode() == userTwo.hashCode());
    }
}
