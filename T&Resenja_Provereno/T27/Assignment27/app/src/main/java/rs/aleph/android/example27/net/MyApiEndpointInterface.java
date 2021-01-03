package rs.aleph.android.example27.net;

/**
 * Created by milossimic on 11/10/16.
 */

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import rs.aleph.android.example27.net.model.Event;

/**
 * Klasa koja opisuje koji tj mapira putanju servisa
 * opisuje koji metod koristimo ali i sta ocekujemo kao rezultat
 *
 * */
public interface MyApiEndpointInterface {

    @GET("artists/{artist}/events")
    Call<List<Event>> getArtistByName(@Path("artist") String artist, @QueryMap Map<String, String> options);
}
