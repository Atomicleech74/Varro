package com.example.varro;

import android.Manifest;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.telecom.PhoneAccount;
import android.telecom.PhoneAccountHandle;
import android.telecom.TelecomManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.example.varro.telecom.VarroConnectionService;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TAG: Main Activity";
    GoogleSignInClient gsic;
    final int RC_SIGN_IN = 4;
    final int REQUEST_PERMISSIONS_CODE = 5;
    ListView l1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //REGISTERN TELECOM MANAGER
        TelecomManager manager = (TelecomManager) getSystemService(TELECOM_SERVICE);
        PhoneAccountHandle phoneAccountHandle = new PhoneAccountHandle(new ComponentName(getBaseContext().getPackageName(),    VarroConnectionService.class.getName()), "varroConnectionServiceId");
        PhoneAccount.Builder builder = PhoneAccount.builder(phoneAccountHandle, "Varro");
        builder.setCapabilities(PhoneAccount.CAPABILITY_CALL_PROVIDER | PhoneAccount.CAPABILITY_CONNECTION_MANAGER| PhoneAccount.CAPABILITY_VIDEO_CALLING );
        PhoneAccount phoneAccount = builder.build();
        manager.registerPhoneAccount(phoneAccount);
        //---------------------------

        // FIND NECESSARY VIEWS
        BottomNavigationView navView = findViewById(R.id.nav_view);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_recents, R.id.navigation_contacts, R.id.navigation_dial)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsic = GoogleSignIn.getClient(this, gso);

        findViewById(R.id.sign_in_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.sign_in_button) {
                    signIn();
                }
            }
        });

        Button contactsButton = findViewById(R.id.c_button);
        if (contactsButton == null) {
            Log.println(Log.ERROR, null, "ERROR FINDING CONTACT BUTTON");
        } else {
            contactsButton.setOnClickListener(l -> {
                if (l.getId() == R.id.c_button) {
                    Log.println(Log.WARN, null, "Contacts Button Found");
                    requestPermissions();
                }
            });
        }

        Button callButton = findViewById(R.id.call_button);
        if(callButton == null){
            Log.println(Log.ERROR, null, "ERROR FINDING CALL BUTTON");
        } else {
            callButton.setOnClickListener(l -> {
                if(l.getId() == R.id.call_button){
                    Log.println(Log.WARN, null, "CALLING NOW");
                    Uri nick = Uri.parse("tel:774-320-5659");
                    Uri peter = Uri.parse("tel:603-548-1484");
                    Uri mike = Uri.parse("tel:203-673-9130");
                    Uri sonyaLibrary = Uri.parse("tel:401-280-3511");
                    Uri sonyaCates = Uri.parse("tel:401-489-9205");
//                    Intent callIntent = new Intent(Intent.ACTION_CALL);
//                    callIntent.setData(nick);
//                    startActivity(callIntent);
                    try {
                        Bundle extras = new Bundle();
                        extras.putBoolean(TelecomManager.EXTRA_START_CALL_WITH_VIDEO_STATE, true);
                        manager.placeCall(sonyaCates, extras);
                    }catch(SecurityException e){
                        e.printStackTrace();
                    }
                }
            });
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        //TO BE IMPLEMENTED///
        //updateUI(account);//
        //////////////////////
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    protected void signIn(){
        Intent signInIntent = gsic.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            // Signed in successfully, show authenticated UI.
            hideSplash();
            String accountName = account.getDisplayName();
            Toast.makeText(this, accountName, Toast.LENGTH_SHORT).show();
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
            hideSplash();

        }
    }

    protected void displayContacts(View v){
        Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
        startManagingCursor(cursor);

        String[] from = {ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER, ContactsContract.CommonDataKinds.Phone._ID};

        int[] to = {android.R.id.text1, android.R.id.text2};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, cursor, from, to);
        l1 = findViewById(R.id.contacts_list);
        l1.setAdapter(adapter);
    }

    protected void hideSplash(){
        findViewById(R.id.splash_view).setVisibility(View.INVISIBLE);
    }

    private void requestPermissions(){
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_CONTACTS, Manifest.permission.CALL_PHONE}, REQUEST_PERMISSIONS_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_PERMISSIONS_CODE){
            if(grantResults.length > 0 && grantResults[0] == PERMISSION_GRANTED){
                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
                displayContacts(null);
            } else {
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}