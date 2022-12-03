package com.example.gtmexplore;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;

import com.example.gtmexplore.databinding.ActivityMainBinding;
import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        com.example.gtmexplore.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        registerTimer();
    }

    private void registerTimer() {
        FirebaseAnalytics fa = FirebaseAnalytics.getInstance(this);

        int propCount = 3;
        Bundle props = new Bundle();
        for (int i = 1; i <= propCount; i++) {
            props.putString("KEY_" + i, "VALUE_" + i);
        }

        Handler handler = new Handler();
        int interval = 6000;
        int eventCount = 3;
        for (long i = 1; i <= eventCount; i++) {
            long finalI = i;
            handler.postDelayed(new Runnable() {
                private final String eventName = "EVENT_" + finalI;
                @Override
                public void run() {
                    //fa.logEvent(eventName, props);
                    handler.postDelayed(this, interval);
                }
            }, i * (interval / eventCount));
        }
    }
}