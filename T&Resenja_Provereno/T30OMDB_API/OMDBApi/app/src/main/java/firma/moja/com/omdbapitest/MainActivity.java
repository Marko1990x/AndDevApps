package firma.moja.com.omdbapitest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.HashMap;

import firma.moja.com.RecyclerTouchListener;
import firma.moja.com.omdbapitest.net.OMDBApiService;
import firma.moja.com.omdbapitest.net.model.OMDBResponse;
import firma.moja.com.omdbapitest.net.model.Search;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private SearchAdapter adapter;
    private RecyclerView searchResult;

    public static String KEY  = "KEY";

    private void callService(String query){
        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("apikey", "YOUR_KEY");
        queryParams.put("s", query);

        Call<OMDBResponse> call = OMDBApiService.apiInterface().searchOMDB(queryParams);
        call.enqueue(new Callback<OMDBResponse>() {
            @Override
            public void onResponse(Call<OMDBResponse> call, Response<OMDBResponse> response) {
                if (response.code() == 200){
                    OMDBResponse resp = response.body();
                    if(resp != null){
                        adapter.addItems(resp.getSearch());
                    }
                }
            }

            @Override
            public void onFailure(Call<OMDBResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new SearchAdapter();

        searchResult = findViewById(R.id.searchResult);
        searchResult.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        searchResult.setItemAnimator(new DefaultItemAnimator());
        searchResult.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.VERTICAL, 16));
        searchResult.setAdapter(adapter);
        searchResult.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), searchResult, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Search movie = adapter.get(position);
                Intent i = new Intent(MainActivity.this, DetailActivity.class);
                i.putExtra(KEY, movie.getImdbID());
                startActivity(i);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        final EditText query = findViewById(R.id.searchText);

        Button search = findViewById(R.id.searchBtn);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Unese Batman -> query.getText().toString().trim()
                callService(query.getText().toString().trim());
            }
        });

    }
}
