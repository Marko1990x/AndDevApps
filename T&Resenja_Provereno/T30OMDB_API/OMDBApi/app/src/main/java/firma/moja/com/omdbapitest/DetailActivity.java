package firma.moja.com.omdbapitest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.squareup.picasso.Picasso;
import java.util.HashMap;
import firma.moja.com.omdbapitest.net.OMDBApiService;
import firma.moja.com.omdbapitest.net.model.MovieInfo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    private void getDetail(String imdbKey){
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("apikey", "YOUR_KEY");
        queryParams.put("i", imdbKey);

        Log.d("REZ", imdbKey);

        Call<MovieInfo> call = OMDBApiService.apiInterface().getMovieData(queryParams);
        call.enqueue(new Callback<MovieInfo>() {
            @Override
            public void onResponse(Call<MovieInfo> call, Response<MovieInfo> response) {
                if (response.code() == 200){
                    Log.d("REZ", "200");

                    MovieInfo resp = response.body();
                    if(resp != null){
                        TextView title = DetailActivity.this.findViewById(R.id.dtitle);
                        title.setText(resp.getTitle());

                        TextView genre = DetailActivity.this.findViewById(R.id.dgenre);
                        genre.setText(resp.getGenre());

                        TextView rated = DetailActivity.this.findViewById(R.id.drated);
                        rated.setText(resp.getRated());

                        ImageView poster = DetailActivity.this.findViewById(R.id.dposter);
                        Picasso.get().load(resp.getPoster()).into(poster);
                    }
                }
            }

            @Override
            public void onFailure(Call<MovieInfo> call, Throwable t) {
                Toast.makeText(DetailActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        String imdbKey = getIntent().getStringExtra(MainActivity.KEY);
        getDetail(imdbKey);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
    }
}
