package com.example.atsumi.backgroundalarm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;


public class BaseActivity extends ActionBarActivity {

    static final String LOG_TAG = BaseActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG, "onCreate");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
        MyApplication myApp = (MyApplication) this.getApplication();
        if (myApp.wasInBackground) {
            Log.d(LOG_TAG, "wasInBackground");
        }

        myApp.stopActivityTransitionTimer();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
        ((MyApplication) this.getApplication()).startActivityTransitionTimer();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

}
