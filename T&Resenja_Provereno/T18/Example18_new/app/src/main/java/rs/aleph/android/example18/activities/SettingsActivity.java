package rs.aleph.android.example18.activities;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import androidx.preference.PreferenceFragmentCompat;
import rs.aleph.android.example18.R;

// Activities extend Activity class
public class SettingsActivity extends AppCompatActivity {

	// onCreate method is a lifecycle method called when he activity is starting
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Replaces activity's content with a an instance of PreferenceFragment
		getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new PrefsFragment()).commit();
	}

	// onOptionsItemSelected method is called whenever an item in your options menu is selected.
	// It is used to handle menu item clicks
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Respond to the action bar's Up/Home button
		if (item.getItemId() == android.R.id.home) {
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
	    return super.onOptionsItemSelected(item);
	}

	// PreferenceFragment is used to automatically load preference GUI from an XML resource and
	// save preferences into preferences.xml
	public static class PrefsFragment extends PreferenceFragmentCompat {

		@Override
		public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
			addPreferencesFromResource(R.xml.preferences);
		}
	}
	
}
