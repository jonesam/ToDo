package com.example.sherwin.todo;

import android.app.PendingIntent;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class loginPage extends AppCompatActivity {

    DateFormat time = new SimpleDateFormat("h:mm a");
    DateFormat date = new SimpleDateFormat("yyyy.MM.dd ");
    NfcAdapter mAdapter;
    PendingIntent pendingIntent;
    private String serialId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        mAdapter = NfcAdapter.getDefaultAdapter(this);
        pendingIntent = PendingIntent.getActivity(
                this, 0, new Intent(this, getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);
        if (mAdapter == null) {
            Toast.makeText(this,
                    "NFC NOT supported on this devices!",
                    Toast.LENGTH_LONG).show();
            finish();
        } else if (!mAdapter.isEnabled()) {
            Toast.makeText(this,
                    "NFC NOT Enabled!",
                    Toast.LENGTH_LONG).show();
            finish();
        }
        //buttonbypass
        Button toMain = (Button) findViewById(R.id.but_bypass);
        toMain.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent myIntent = new Intent(loginPage.this,MainActivity.class);
                startActivity(myIntent);
            }
        });
        }

    @Override
    public void onResume() {
        super.onResume();
        mAdapter.enableForegroundDispatch(this, pendingIntent, null, null);
    }
    @Override
    public void onPause(){
        super.onPause();
        mAdapter.disableForegroundDispatch(this);

    }
    @Override
    public void onNewIntent(Intent intent) {

        String action = intent.getAction();
        if (NfcAdapter.ACTION_TAG_DISCOVERED.equals(action) ||
                NfcAdapter.ACTION_TECH_DISCOVERED.equals(action)) {
            Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
            if (tag != null) {
                ((GlobalData) getApplication()).setUserTag(tag);
                String serialID = ((GlobalData) this.getApplication()).getUserID();
                if(serialID.equalsIgnoreCase("04950f4ae53f80")){
                    String jobPath = "USERS/04950F4AE53F80/LOGTIME/";
                    final DatabaseReference myRef = FirebaseDatabase.getInstance().getReference(jobPath);
                   // LogClass logClass = new LogClass(date.format(Calendar.getInstance().getTime()), time.format(Calendar.getInstance().getTime()),"");
                   // myRef.child(date.format(Calendar.getInstance().getTime())).setValue(logClass);

                    Intent goToConfirm = new Intent(this, confirmLogin.class);
                    startActivity(goToConfirm);
                }else {
                    Toast.makeText(this,"This is not an employee!", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

}




