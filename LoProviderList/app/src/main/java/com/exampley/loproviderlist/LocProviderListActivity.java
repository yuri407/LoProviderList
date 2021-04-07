package com.exampley.loproviderlist;

import androidx.appcompat.app.AppCompatActivity;

import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class LocProviderListActivity extends AppCompatActivity {
    TextView mTextView;
    LocationManager locMgr;
    List<String> strings = new ArrayList<>();
    Button mbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.txtOutput);
        mbutton = findViewById(R.id.button);

       // locMgr = (LocationManager) getSystemService(LOCATION_SERVICE);

        //locProviders = locMgr.getAllProviders();

        mbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String s = "";
                int i = 0;
                for(String string : strings) {
                    s += "Loc. Provider " + strings.get(i) + "\n"
                            + "Status: " + locMgr.isProviderEnabled(strings.get(i)) + "\n\n";

                }
                /*for (int i = 0; i < locProviders.size(); i++) {
                    s += "Loc. Provider " + locProviders.get(i) + "\n"
                            + "Status: " + locMgr.isProviderEnabled(locProviders.get(i)) + "\n\n";
                }*/
                mTextView.setText(s);
            }
        });
    }
}