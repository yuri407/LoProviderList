package com.exampley.loproviderlist;

import androidx.appcompat.app.AppCompatActivity;

import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class LocProviderListActivity extends AppCompatActivity {
    TextView mTextView;
    LocationManager locMgr;
    List<String> locProviders;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.txtOutput);
        locMgr = (LocationManager) getSystemService(LOCATION_SERVICE);
        button = findViewById(R.id.button);

        locProviders = locMgr.getAllProviders();
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String s = "";
                for (int i = 0; i < locProviders.size(); i++) {
                    s += "Loc. Provider " + locProviders.get(i) + "\n"
                            + "Status: " + locMgr.isProviderEnabled(locProviders.get(i)) + "\n\n";
                }
                mTextView.setText(s);
            }
        });
    }
}