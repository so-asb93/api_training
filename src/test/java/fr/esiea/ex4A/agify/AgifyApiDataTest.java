package fr.esiea.ex4A.agify;

import fr.esiea.ex4A.client.AgifyApiData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AgifyApiDataTest {

    @Test
    void testEquals() {
        AgifyApiData userOne = new AgifyApiData("sofiane", 21, 1, "FR");
        AgifyApiData userTwo = new AgifyApiData("sofiane", 21, 1, "FR");

        Assertions.assertTrue(userOne.equals(userTwo) && userTwo.equals(userOne));
        Assertions.assertTrue(userOne.hashCode() == userTwo.hashCode());
    }
}
