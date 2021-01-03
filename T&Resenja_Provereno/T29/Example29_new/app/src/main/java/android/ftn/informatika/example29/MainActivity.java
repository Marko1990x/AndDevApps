package android.ftn.informatika.example29;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.preference.PreferenceManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.views.overlay.MinimapOverlay;
import org.osmdroid.views.overlay.Overlay;
import org.osmdroid.views.overlay.ScaleBarOverlay;
import org.osmdroid.views.overlay.compass.CompassOverlay;
import org.osmdroid.views.overlay.compass.InternalCompassOrientationProvider;
import org.osmdroid.views.overlay.gestures.RotationGestureOverlay;
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements LocationListener {

    private final int REQUEST_PERMISSIONS_REQUEST_CODE = 1;
    private MapView map = null;

    private IMapController mapController;
    private RotationGestureOverlay mRotationGestureOverlay;
    private CompassOverlay mCompassOverlay;
    private ScaleBarOverlay mScaleBarOverlay;
    private MinimapOverlay mMinimapOverlay;
    private MyLocationNewOverlay mLocationOverlay;

    private Map<String, Overlay> markers;

    private GeoPoint startPoint;

    private LocationManager locationManager;
    private AlertDialog dialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //load/initialize the osmdroid configuration, this can be done
        try {
            Context ctx = getApplicationContext();
            Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));
        }catch (NullPointerException ignored){ }
        //setting this before the layout is inflated is a good idea
        //it 'should' ensure that the map has a writable location for the map cache, even without permissions
        //if no tiles are displayed, you can try overriding the cache path using Configuration.getInstance().setCachePath
        //see also StorageUtils
        //note, the load method also sets the HTTP User Agent to your application's package name, abusing osm's
        //tile servers will get you banned based on this string

        //inflate and create the map
        setContentView(R.layout.activity_main);
        markers = new HashMap<>();
        setupMap();
        configureOverlays();
        addMarker();

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
    }

    private void configureOverlays(){
        //Overlay for rotation gestures on the map
        mRotationGestureOverlay = new RotationGestureOverlay(map);
        mRotationGestureOverlay.setEnabled(true);
        //map.getZoomController().setVisibility(CustomZoomButtonsController.Visibility.ALWAYS);
        map.setMultiTouchControls(true);
        map.getOverlays().add(mRotationGestureOverlay);

        //Overlay for compass on the map
        mCompassOverlay = new CompassOverlay(this, new InternalCompassOrientationProvider(this), map);
        mCompassOverlay.enableCompass();
        map.getOverlays().add(mCompassOverlay);

        //Add map scale bar overlay
        mScaleBarOverlay = new ScaleBarOverlay(map);
        mScaleBarOverlay.setCentred(true);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        mScaleBarOverlay.setScaleBarOffset(dm.widthPixels / 2, 30);
        map.getOverlays().add(mScaleBarOverlay);

        //minimap overlay
        mMinimapOverlay = new MinimapOverlay(this, map.getTileRequestCompleteHandler());
        mMinimapOverlay.setWidth(dm.widthPixels / 5);
        mMinimapOverlay.setHeight(dm.heightPixels / 5);
        //optionally, you can set the minimap to a different tile source
        //mMinimapOverlay.setTileSource(....);
        map.getOverlays().add(mMinimapOverlay);

        //my current location overlay
        mLocationOverlay = new MyLocationNewOverlay(new GpsMyLocationProvider(this),map);
        mLocationOverlay.enableMyLocation();
        map.getOverlays().add(mLocationOverlay);
    }

    private void addMarker(){
        Marker startMarker = new Marker(map);
        startMarker.setPosition(startPoint);
        startMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        map.getOverlays().add(startMarker);
        startMarker.setIcon(ContextCompat.getDrawable(this, R.drawable.person));
        startMarker.setTitle("Start point");
//        startMarker.setOnMarkerClickListener(new Marker.OnMarkerClickListener() {
//            @Override
//            public boolean onMarkerClick(Marker marker, MapView mapView) {
//                Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
//                return false;
//            }
//        });
        markers.put(startMarker.getId(), startMarker);
    }

    private void setupMap(){
        map = findViewById(R.id.map);
        map.setTileSource(TileSourceFactory.MAPNIK);

        mapController = map.getController();
        mapController.setZoom(9.5);
        startPoint = new GeoPoint(48.8583, 2.2944);
        mapController.setCenter(startPoint);
    }

    private String setupLocationProvider(){
        //specificiramo krijterijum da dobijamo informacije sa svih izvora
        //ako korisnik to dopusti
        Criteria criteria = new Criteria();

        //sistemskom servisu prosledjujemo taj kriterijum da bi
        //mogli da dobijamo informacje sa tog izvora
        return locationManager.getBestProvider(criteria, true);
    }

    @Override
    public void onResume() {
        super.onResume();
        //this will refresh the osmdroid configuration on resuming.
        //if you make changes to the configuration, use
        //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));
        map.onResume(); //needed for compass, my location overlays, v6.0.0 and up

        //handle permissions first, before map is created. not depicted here
        if(!checkLocationPermission()){
            requestPermissionsIfNecessary(new String[] {
                    // if you need to show the current location, uncomment the line below
                    // Manifest.permission.ACCESS_FINE_LOCATION,
                    // WRITE_EXTERNAL_STORAGE is required in order to show the map
                    Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION
            });
        }

        boolean gps = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        boolean wifi = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

        if (!gps && !wifi) {
            showLocatonDialog();
        } else {
            if (checkLocationPermission()) {
                if (ContextCompat.checkSelfPermission(this,
                        Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

                    //Request location updates:
                    locationManager.requestLocationUpdates(setupLocationProvider(), 0, 0, this);
                }else if(ContextCompat.checkSelfPermission(this,
                        Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED){

                    //Request location updates:
                    locationManager.requestLocationUpdates(setupLocationProvider(), 0, 0, this);
                }
            }
        }
    }

    private void showLocatonDialog() {
        if (dialog == null) {
            dialog = new LocationDialog(this).prepareDialog();
        } else {
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
        }

        dialog.show();
    }

    @Override
    public void onPause() {
        super.onPause();
        //this will refresh the osmdroid configuration on resuming.
        //if you make changes to the configuration, use
        //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //Configuration.getInstance().save(this, prefs);
        map.onPause();  //needed for compass, my location overlays, v6.0.0 and up

        locationManager.removeUpdates(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == REQUEST_PERMISSIONS_REQUEST_CODE) {
            //ArrayList<String> permissionsToRequest = new ArrayList<>(Arrays.asList(permissions).subList(0, grantResults.length));
//            if (permissionsToRequest.size() > 0) {
//                ActivityCompat.requestPermissions(
//                        this,
//                        permissionsToRequest.toArray(new String[0]),
//                        REQUEST_PERMISSIONS_REQUEST_CODE);
//            }
            if (grantResults.length > 0
                    && grantResults[1] == PackageManager.PERMISSION_GRANTED) {

                // permission was granted, yay! Do the
                // location-related task you need to do.
                if (ContextCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.ACCESS_FINE_LOCATION)
                        == PackageManager.PERMISSION_GRANTED) {

                    //Request location updates:
                    locationManager.requestLocationUpdates(setupLocationProvider(), 0, 0, this);
                }

            } else if (grantResults.length > 0
                    && grantResults[2] == PackageManager.PERMISSION_GRANTED){

                // permission denied, boo! Disable the
                // functionality that depends on this permission.
                if (ContextCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.ACCESS_COARSE_LOCATION)
                        == PackageManager.PERMISSION_GRANTED) {

                    //Request location updates:
                    locationManager.requestLocationUpdates(setupLocationProvider(), 0, 0, this);
                }

            }
        }
    }

    private void requestPermissionsIfNecessary(String[] permissions) {
        ArrayList<String> permissionsToRequest = new ArrayList<>();
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission)
                    != PackageManager.PERMISSION_GRANTED) {
                // Permission is not granted
                permissionsToRequest.add(permission);
            }
        }
        if (permissionsToRequest.size() > 0) {
            ActivityCompat.requestPermissions(
                    this,
                    permissionsToRequest.toArray(new String[0]),
                    REQUEST_PERMISSIONS_REQUEST_CODE);
        }
    }

    public boolean checkLocationPermission() {
        boolean fineLocation = ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;
        boolean coarseLocation = ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED;
        boolean storage = ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
        return fineLocation && coarseLocation && storage;
    }

    @Override
    public void onLocationChanged(Location location) {
        Toast.makeText(this, location.getLatitude()+" "+location.getLongitude(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}