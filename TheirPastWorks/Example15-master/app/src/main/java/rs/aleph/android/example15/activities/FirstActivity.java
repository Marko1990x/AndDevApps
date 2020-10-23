package rs.aleph.android.example15.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import rs.aleph.android.example15.R;
import rs.aleph.android.example15.model.Fruit;
import rs.aleph.android.example15.provider.FruitProvider;

// Each activity extends Activity class
public class FirstActivity extends Activity {

	// onCreate method is a lifecycle method called when he activity is starting
	@Override
	protected void onCreate(Bundle savedInstanceState) 	{

		// Each lifecycle method should call the method it overrides
		super.onCreate(savedInstanceState);
		// setContentView method draws UI
		setContentView(R.layout.activity_first);

		// Shows a toast message (a pop-up message)
		Toast toast = Toast.makeText(getBaseContext(), "FirstActivity.onCreate()", Toast.LENGTH_SHORT);
		toast.show();

        // Loads fruits from array resource
        final List<String> fruitNames = FruitProvider.getFruitNames();

        // Creates an ArrayAdaptar from the array of String
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.list_item, fruitNames);
        ListView listView = (ListView) findViewById(R.id.listofFruits);

        // Assigns ArrayAdaptar to ListView
        listView.setAdapter(dataAdapter);

        // Starts the SecondActivity and sends it the selected URL as an extra data
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
	}

	// onStart method is a lifecycle method called after onCreate (or after onRestart when the
	// activity had been stopped, but is now again being displayed to the user)
	@Override
	protected void onStart() {

		super.onStart();

		// Shows a toast message (a pop-up message)
		Toast toast = Toast.makeText(getBaseContext(), "FirstActivity.onStart()", Toast.LENGTH_SHORT);
		toast.show();
	}

	// onRestart method is a lifecycle method called after onStop when the current activity is
	// being re-displayed to the user
	@Override
    protected void onRestart() {

		super.onRestart();

		// Shows a toast message (a pop-up message)
		Toast toast = Toast.makeText(getBaseContext(), "FirstActivity.onRestart()", Toast.LENGTH_SHORT);
		toast.show();
    }

	// onResume method is a lifecycle method called after onRestoreInstanceState, onRestart, or
	// onPause, for your activity to start interacting with the user
	@Override
	protected void onResume() {

		super.onResume();

		// Shows a toast message (a pop-up message)
		Toast toast = Toast.makeText(getBaseContext(), "FirstActivity.onResume()", Toast.LENGTH_SHORT);
		toast.show();
	}

	// onPause method is a lifecycle method called when an activity is going into the background,
	// but has not (yet) been killed
	@Override
	protected void onPause() {

		super.onPause();

		// Shows a toast message (a pop-up message)
		Toast toast = Toast.makeText(getBaseContext(), "FirstActivity.onPause()", Toast.LENGTH_SHORT);
		toast.show();
	}

	// onStop method is a lifecycle method called when the activity are no longer visible to the user
	@Override
	protected void onStop() {

		super.onStop();

		// Shows a toast message (a pop-up message)
		Toast toast = Toast.makeText(getBaseContext(), "FirstActivity.onStop()", Toast.LENGTH_SHORT);
		toast.show();
	}

	// onDestroy method is a lifecycle method that perform any final cleanup before an activity is destroyed
	@Override
	protected void onDestroy() {

		super.onDestroy();

		// Shows a toast message (a pop-up message)
		Toast toast = Toast.makeText(getBaseContext(), "FirstActivity.onDestroy()", Toast.LENGTH_SHORT);
		toast.show();
	}
}
