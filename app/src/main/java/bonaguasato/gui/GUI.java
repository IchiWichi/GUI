package bonaguasato.gui;

import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;

public class GUI extends AppCompatActivity implements AsyncResponse,View.OnClickListener {

    EditText etUsername, etPassword;

    private DBHandler helper;




    private FirebaseAnalytics mFirebaseAnalytics;
    private FaceOverlayView mFaceOverlayView;
    public static Location location;
    private LocationManager locationManager;
    private LocationListener listener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gui);

      //  locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
       // listener = new LocationListenerCustom();
        //statusCheck();
        //requestLocation();
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        DBHandler helper = new DBHandler(this);

// Inserting users/Rows
        Log.d("Insert: ", "Inserting ..");
        helper.addUsers( "PHILIP", "default");
        helper.addUsers( "KOUICHI", "default");
        helper.addUsers( "GUEST", "");


       Button BtnLogin = (Button) findViewById(R.id.BtnLogin);


        BtnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                // Toast.makeText(GUI.this,""+loc.getLatitude(),Toast.LENGTH_LONG).show();
               // Log.d("test",""+location.getLatitude());
             //   if (location != null)
               //     Toast.makeText(v.getContext(), ""+location.getLatitude(), Toast.LENGTH_SHORT).show();
                DBHandler db = new DBHandler(v.getContext());
                EditText user = (EditText)findViewById(R.id.etUsername);
                EditText pass = (EditText)findViewById(R.id.etPassword);
                String userValue = user.getText().toString();
                String passValue = pass.getText().toString();
                boolean accountMatch = db.validateUser(userValue, passValue);
                int charUserLength = userValue.length();
                int charPassLength = passValue.length();

                if (accountMatch) {
                    Intent toSuc = new Intent(GUI.this, Webview.class);
                    startActivity(toSuc);
                } else if (userValue.equals("") && passValue.equals("")) {
                    Toast.makeText(GUI.this, "Fields Empty", Toast.LENGTH_SHORT).show();
                } else if (charUserLength < 5 && charPassLength < 5) { // At least 6 characters anything less is too short
                    Toast.makeText(GUI.this, "Characters Too Short", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(GUI.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


      @Override
   public void onClick(View view) {

    HashMap postData = new HashMap();

      Intent myIntent = new Intent(GUI.this, homepage.class);
     startActivity(myIntent);

     postData.put("txtUsername", etUsername.getText().toString());
     postData.put("txtPassword", etPassword.getText().toString());


     PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData);
    //task.execute("https://console.firebase.google.com");
}


    @Override
    public void processFinish(String s) {

    }

   /* public void statusCheck() {
        final LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            buildAlertMessageNoGps();

        }
    }
    private void buildAlertMessageNoGps() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Your GPS seems to be disabled, do you want to enable it?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        dialog.cancel();
                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();
    }
    private void requestLocation() {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE
        ) != PackageManager.PERMISSION_GRANTED  || ActivityCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED  || ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION,android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.INTERNET,android.Manifest.permission.CAMERA,android.Manifest.permission.READ_EXTERNAL_STORAGE,android.Manifest.permission.WRITE_EXTERNAL_STORAGE}
                        ,10);
            }
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, listener);
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, listener);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 10:
                requestLocation();
                break;
            default:
                break;
        }
    }
*/
}


