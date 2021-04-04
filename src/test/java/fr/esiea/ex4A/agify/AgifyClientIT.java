package fr.esiea.ex4A.agify;

import fr.esiea.ex4A.client.AgifyApiData;
import fr.esiea.ex4A.client.AgifyClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class AgifyClientIT {

    private final AgifyClient agifyClient;

    public AgifyClientIT(@Autowired AgifyClient agifyClient) {
        this.agifyClient = agifyClient;
    }

    @Test
    void agify_age_prediction() throws IOException {

        Call<AgifyApiData> apiCall = agifyClient.agePredict("sofiane", "FR");
        Response<AgifyApiData> response = apiCall.execute();

        assertThat(response.isSuccessful())
            .isEqualTo(true);
        assertThat(response.body().name).isEqualTo("sofiane");
        assertThat(response.body().country_id).isEqualTo("FR");
    }
}
