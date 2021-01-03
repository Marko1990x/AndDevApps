package firma.moja.com.omdbapitest.net;

import java.util.Map;

import firma.moja.com.omdbapitest.net.model.MovieInfo;
import firma.moja.com.omdbapitest.net.model.OMDBResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface OMDBApiEndpoint {

    //http://www.omdbapi.com/?apikey=[yourkey]&s=Batman
    @GET("/")
    Call<OMDBResponse> searchOMDB(@QueryMap Map<String, String> options);

    //http://www.omdbapi.com/?apikey=[yourkey]&i=imdbid
    @GET("/")
    Call<MovieInfo> getMovieData(@QueryMap Map<String, String> options);

}
