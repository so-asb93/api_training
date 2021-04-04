package fr.esiea.ex4A.client;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AgifyClient {
    @GET("/")
    Call<AgifyApiData> agePredict(@Query("name") String userName, @Query("country_id") String userCountry);
}
