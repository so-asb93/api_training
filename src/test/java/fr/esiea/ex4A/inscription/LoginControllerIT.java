package fr.esiea.ex4A.inscription;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class LoginControllerIT {

    private final MockMvc mockMvc;

    @MockBean
    private LoginRepository repository;

    LoginControllerIT(@Autowired MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    void login() throws Exception {
        when(repository.addUser(any(LoginData.class))).thenReturn(new LoginData());

        mockMvc
            .perform(MockMvcRequestBuilders.post("/api/inscription")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                    {
                    "userEmail": "machin@truc.com",
                    "userName": "machin",
                    "userTweeter": "machin45",
                    "userCountry": "FR",
                    "userSex": "M",
                    "userSexPref": "M"
                    }""")
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("User added")));

        verify(repository).addUser(new LoginData("machin", "machin@truc.com",
            "machin45", "FR", "M", "M"));
    }
}
