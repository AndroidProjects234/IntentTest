package com.example.intenttest;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class BuckysIntentService extends IntentService {
//Service is what runs in background.Threads are created automatically
    private static final String TAG="com.example.intenttest";
    public BuckysIntentService() {
        super("BuckysIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        //This is what the service does
        Log.i(TAG,"The service has now started");
    }
}
