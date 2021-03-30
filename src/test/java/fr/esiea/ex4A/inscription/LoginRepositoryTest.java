package fr.esiea.ex4A.inscription;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LoginRepositoryTest {

    private final LoginRepository loginRepository = new LoginRepository();

    @Test
    void adding_user_with_real_credentials() {
        LoginData user = new LoginData("Test", "test@test.com",
            "tweeterTest", "FR", "M", "M");
        loginRepository.addUser(user);

        Assertions.assertTrue(loginRepository.UserIsExist(user));
        Assertions.assertEquals(1, loginRepository.loginUsers.size());
    }

    @Test
    void login_of_user_with_default() {
        LoginData user = new LoginData();
        loginRepository.addUser(user);

        Assertions.assertTrue(loginRepository.UserIsExist(user));
        Assertions.assertEquals(1, loginRepository.loginUsers.size());
    }
}
