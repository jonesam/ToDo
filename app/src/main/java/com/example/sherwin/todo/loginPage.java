package com.example.sherwin.todo;

import android.app.PendingIntent;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class loginPage extends AppCompatActivity {
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
                    Intent goToConfirm = new Intent(this, confirmLogin.class);
                    startActivity(goToConfirm);
                }else {
                    Toast.makeText(this,"This is not an employee!", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }



}




