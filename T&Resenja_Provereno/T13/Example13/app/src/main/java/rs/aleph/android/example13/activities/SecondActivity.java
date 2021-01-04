package rs.aleph.android.example13.activities;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import rs.aleph.android.example13.R;

// Each activity extends Activity class
public class SecondActivity extends Activity {

    private static final int PERMISSIONS_REQUEST_INTERNET = 0;

    // onCreate method is a lifecycle method called when he activity is starting
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Each lifecycle method should call the method it overrides
        super.onCreate(savedInstanceState);
        // setContentView method draws UI
        setContentView(R.layout.second_activity);

        // Shows a toast message (a pop-up message)
        Toast toast = Toast.makeText(getBaseContext(), "SecondActivity.onCreate()", Toast.LENGTH_SHORT);
        toast.show();

        // Checks for permission dynamically (Manifest.permission.INTERNET is a normal permission that is granted automatically,
        // but for the sake of explanation ...)
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {

            // PERMISSIONS_REQUEST_INTERNET is an app-defined int constant.
            // The callback method gets the result of the request.
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, PERMISSIONS_REQUEST_INTERNET);

        } else {

            // Loads an URL into the WebView
            String URL = getIntent().getStringExtra("URL");
            if (!URL.trim().equalsIgnoreCase("")) {
                WebView myWebView = (WebView) findViewById(R.id.pageInfo);
                myWebView.getSettings().setJavaScriptEnabled(true);
                myWebView.setWebViewClient(new MyWebViewClient());
                myWebView.loadUrl(URL.trim());
            }

        }
    }

    // onStart method is a lifecycle method called after onCreate (or after onRestart when the
    // activity had been stopped, but is now again being displayed to the user)
    @Override
    protected void onStart() {
        super.onStart();

        Toast toast = Toast.makeText(getBaseContext(), "SecondActivity.onStart()", Toast.LENGTH_SHORT);
        toast.show();
    }

    // onRestart method is a lifecycle method called after onStop when the current activity is
    // being re-displayed to the user
    @Override
    protected void onRestart() {
        super.onRestart();

        Toast toast = Toast.makeText(getBaseContext(), "SecondActivity.onRestart()", Toast.LENGTH_SHORT);
        toast.show();
    }

    // onResume method is a lifecycle method called after onRestoreInstanceState, onRestart, or
    // onPause, for your activity to start interacting with the user
    @Override
    protected void onResume() {
        super.onResume();

        Toast toast = Toast.makeText(getBaseContext(), "SecondActivity.onResume()", Toast.LENGTH_SHORT);
        toast.show();
    }

    // onPause method is a lifecycle method called when an activity is going into the background,
    // but has not (yet) been killed
    @Override
    protected void onPause() {
        super.onPause();

        Toast toast = Toast.makeText(getBaseContext(), "SecondActivity.onPause()", Toast.LENGTH_SHORT);
        toast.show();
    }

    // onStop method is a lifecycle method called when the activity are no longer visible to the user
    @Override
    protected void onStop() {
        super.onStop();

        Toast toast = Toast.makeText(getBaseContext(), "SecondActivity.onStop()", Toast.LENGTH_SHORT);
        toast.show();
    }

    // onDestroy method is a lifecycle method that perform any final cleanup before an activity is destroyed
    @Override
    protected void onDestroy() {
        super.onDestroy();

        Toast toast = Toast.makeText(getBaseContext(), "SecondActivity.onDestroy()", Toast.LENGTH_SHORT);
        toast.show();
    }

    // Inner class needed to loas an URL into the WebView
    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            return false;
        }
    }

    // This method is invoked asynchronously for every call on requestPermissions
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSIONS_REQUEST_INTERNET: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // Permission was granted

                    // Loads an URL into the WebView
                    String URL = getIntent().getStringExtra("URL");
                    if (!URL.trim().equalsIgnoreCase("")) {
                        WebView myWebView = (WebView) findViewById(R.id.pageInfo);
                        myWebView.getSettings().setJavaScriptEnabled(true);
                        myWebView.setWebViewClient(new MyWebViewClient());
                        myWebView.loadUrl(URL.trim());
                    }

                } else {

                    // Permission denied
                }
                return;
            }

            // other 'case' lines to check for other permissions this app might request
        }
    }
}
