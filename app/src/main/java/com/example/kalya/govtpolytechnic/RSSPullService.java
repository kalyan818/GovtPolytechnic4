package com.example.kalya.govtpolytechnic;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by kalya on 14-Mar-17.
 */

public class RSSPullService extends IntentService {

    public RSSPullService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent workIntent) {
        // Gets data from the incoming Intent
        String dataString = workIntent.getDataString();
    }
}
