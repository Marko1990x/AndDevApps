package firebaseapp.com.recyclerviewextraadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;  // this is needed because it doesnt load all files at once for performance
    private RecyclerView.LayoutManager mlayoutManager; // this is needed // aligns the single items in our list


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<ExampleItem> exampleItems =  new ArrayList<>();
        exampleItems.add(new ExampleItem(R.drawable.ic_android,"line1","line2"));
        exampleItems.add(new ExampleItem(R.drawable.ic_audio,"line3","line4"));
        exampleItems.add(new ExampleItem(R.drawable.ic_sun,"line5","line6"));

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true); // if the size does not change regardless how many items it has

        mlayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(exampleItems); // this is the list with data that gets passed to my adapter

        mRecyclerView.setLayoutManager(mlayoutManager); // pass the adapter to the layout manager
        mRecyclerView.setAdapter(mAdapter);
    }
}