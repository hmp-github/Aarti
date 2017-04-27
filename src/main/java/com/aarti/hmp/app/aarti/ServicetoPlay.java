package com.aarti.hmp.app.aarti;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import static com.aarti.hmp.app.aarti.Second_Activity.player;

public class ServicetoPlay extends Service {
    public ServicetoPlay() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        player.start();
        player.setLooping(true);
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.pause();

    }



    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");


    }
}
