package com.aarti.hmp.app.aarti;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;


public class Second_Activity extends AppCompatActivity implements View.OnClickListener {

    InterstitialAd mInterstitialAd;
    ImageButton mPlay_Pause;
    SeekBar sek;
    boolean isPlayeron = true;
    static   MediaPlayer player;
    ImageView img;
    Handler seekHandler = new Handler();
    int song_address;
    int Image_Address;
    PhoneStateListener phoneStateListener;
    protected static final int notinum = 73465;
    Boolean fromUser;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        Bundle extras = getIntent().getExtras();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_);
        mPlay_Pause = (ImageButton) findViewById(R.id.fab_button);
        mPlay_Pause.setOnClickListener(this);


        MobileAds.initialize(getApplicationContext(), " ca-app-pub-3940256099942544~3347511713");

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-6027226674629801/3360783572");
        AdRequest adRequestf = new AdRequest.Builder().build();
        mInterstitialAd.loadAd(adRequestf);
        mInterstitialAd.setAdListener(new AdListener() {
          public void onAdLoaded() {
                showInterstitial();
            }
        });


        if (getIntent() != null) {

            song_address = extras.getInt("song_address");
            Image_Address = extras.getInt("Image_Address");

        }
        getInit();
        seekUpdation();


    }

   private void showInterstitial() {
        AdRequest adRequestf = new AdRequest.Builder().build();
        mInterstitialAd.loadAd(adRequestf);
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();

        }
    }

    public void getInit() {
        sek = (SeekBar) findViewById(R.id.seekbar1);
        player = MediaPlayer.create(this, song_address);
        sek.setMax(player.getDuration());
        img = (ImageView) findViewById(R.id.arti_image);
        img.setImageResource(Image_Address);


    }

    private void toggleButtonImage(int noti) {
        if (isPlayeron) {

            CallState();
            if (noti == 1) {
                addNotification(notinum);
            }
            mPlay_Pause.setImageResource(R.drawable.pause);
        } else {

            CallStateNone();
            if (noti == 1) {
                cancelNotification(notinum);
            }
            mPlay_Pause.setImageResource(R.drawable.play);
        }
    }


    Runnable run = new Runnable() {

        @Override
        public void run() {
            seekUpdation();
        }
    };

    public void seekUpdation() {
        if(player != null){
            int progresscurrent = player.getCurrentPosition();
            sek.setProgress(progresscurrent);
        }
        seekHandler.postDelayed(run, 1000);

        sek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                fromUser = false;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                fromUser = true;
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(player != null && fromUser){
                    player.seekTo(progress);
                }
            }
        });

        //  sek.setProgress(player.getCurrentPosition());
        //  seekHandler.postDelayed(run, 1000);
    }

    @Override
    public void onClick(View view) {


        if (isPlayeron) {

            startService(new Intent(getBaseContext(), ServicetoPlay.class));
            toggleButtonImage(1);
            isPlayeron = false;
        } else {

            stopService(new Intent(getBaseContext(), ServicetoPlay.class));
            toggleButtonImage(1);
            isPlayeron = true;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        // showInterstitial();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
        player.pause();
        isPlayeron = false;

        toggleButtonImage(1);
        CallStateNone();

    }

    private void addNotification(int notinum) {
        Bitmap icon = BitmapFactory.decodeResource(getResources(),
                R.drawable.ganeshji_image);
        NotificationCompat.Builder builder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.play)
                        .setLargeIcon(icon)
                        .setContentTitle("AARTI")
                        .setContentText("Aarti is Playing...")
                        .setOngoing(true);


        Intent notificationIntent = new Intent(this, Second_Activity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, notinum, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(notinum, builder.build());
    }

    public void cancelNotification(int notifyId) {
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.cancel(notifyId);
    }

    public void CallState() {

        PhoneStateListener phoneStateListener = new PhoneStateListener() {
            @Override
            public void onCallStateChanged(int state, String incomingNumber) {
                if (state == TelephonyManager.CALL_STATE_RINGING) {
                    player.pause();
                    isPlayeron = false;
                    toggleButtonImage(0);
                } else if (state == TelephonyManager.CALL_STATE_OFFHOOK) {
                    player.pause();
                    isPlayeron = false;
                    toggleButtonImage(0);
                }
                super.onCallStateChanged(state, incomingNumber);
            }
        };

        TelephonyManager mgr = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        if (mgr != null) {
            mgr.listen(phoneStateListener, PhoneStateListener.LISTEN_CALL_STATE);

        }
    }

    public void CallStateNone() {
        TelephonyManager mgr = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        if (mgr != null) {
            mgr.listen(phoneStateListener, PhoneStateListener.LISTEN_NONE);
        }
    }


}

