package firebaseapp.com.recyclerviewextraadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<ExampleItem> mExampleList;
    private Button buttonInsert;
    private Button buttonRemove;
    private EditText editTextInsert;
    private EditText editTextRemove;


    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;  // this is needed because it doesnt load all files at once for performance
    private RecyclerView.LayoutManager mlayoutManager; // this is needed // aligns the single items in our list

    //tutroial guide links
    //https://www.youtube.com/watch?v=Nw9JF55LDzE // part1
    // https://www.youtube.com/watch?v=17NbUcEts9c //part2

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createExampleList();
        buildRecyclerView();


        buttonInsert = findViewById(R.id.button_insert);
        buttonRemove = findViewById(R.id.button_remove);
        editTextInsert = findViewById(R.id.editText_insert);
        editTextRemove = findViewById(R.id.editText_remove);
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = Integer.parseInt(editTextInsert.getText().toString());
                //get the position from the xml field and pass to the method that will make an object to inserts
                insertItem(position);
            }
        });
        buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = Integer.parseInt(editTextRemove.getText().toString());
                removeItem(position);
            }
        });


    }
    // warning the app works however if the postion that is passed is greater then the total size of the array
    // it will break the number passed needs to be limited to the size of the current array
    public void insertItem(int position){
        // if the position is passed the app will know where in the list to stick the new item
        mExampleList.add(position,
                new ExampleItem(R.drawable.ic_android,"New Item @position "+position,"this is extra line"));

        mAdapter.notifyItemInserted(position);  // this adds animation
        //mAdapter.notifyDataSetChanged(); read bellow
    }
    public void removeItem(int position){
        mExampleList.remove(position);
        mAdapter.notifyItemRemoved(position);
       // mAdapter.notifyDataSetChanged(); this method works only as last resort because i wont be able to use any animations on it
        // because it refreshes the whole list
    }


    public void createExampleList(){
        // added more items to test the scroll
        mExampleList =  new ArrayList<>();
        mExampleList.add(new ExampleItem(R.drawable.ic_android,"line1","line2"));
        mExampleList.add(new ExampleItem(R.drawable.ic_audio,"line3","line4"));
        mExampleList.add(new ExampleItem(R.drawable.ic_sun,"line5","line6"));

    }
    public void buildRecyclerView(){
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true); // if the size does not change regardless how many items it has

        mlayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(mExampleList); // this is the list with data that gets passed to my adapter

        mRecyclerView.setLayoutManager(mlayoutManager); // pass the adapter to the layout manager
        mRecyclerView.setAdapter(mAdapter);
    }
}