package com.aarti.hmp.app.aarti;


import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import static com.aarti.hmp.app.aarti.Second_Activity.notinum;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lv;
    Context context;
    CardView cardview;



    public static int[] prgmImages = {R.drawable.ganeshji_image, R.drawable.shivji_image, R.drawable.hanumanji_image, R.drawable.krishnaji_image, R.drawable.saibabaji_image,R.drawable.vishnuji_image,
            R.drawable.sherawaliji_image,R.drawable.laxmiji_image,R.drawable.shanidev_image};

    public static String[] prgmNameList = {"गणेश जी की आरती", "शिव जी की आरती", "हनुमान जी की आरती  ", "कृष्णा जी की आरती","साई बाबा की आरती","विष्णु जी की आरती ","शेरावाली माता की आरती ","लक्ष्मी जी की आरती ","शनि देव की आरती "};

    public static String [] prgmDetailList = {"जय गणेश जय गणेश जय गणेश देवा माता तेरी पारवती पिता महा देवा....","जय शिव ओंकारा जय शिव ओंकारा ब्रह्मा, विष्णु , सदाशिव...","आरती कीजे हनुमान लाला की ....","आरती कुञ्ज बिहारी की श्री गिरधर कृष्ण मुरारी की...","आरती श्री साई गुरुवर की परमानन्द सदा सुरवर की ....","ॐ जय जगदीश हरे स्वामी जय जगदीश हरे....","जय अम्बे गौरी मैया जय श्यामा गौरी....","ॐ जय लक्ष्मी माता मैया जय लक्ष्मी माता....","जय जय श्री शनिदेव भगतन हितकारी...."};





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(getApplicationContext(), " ca-app-pub-6027226674629801~1079275175");

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mAdView.loadAd(adRequest);



        context = this;
        cardview = (CardView)findViewById(R.id.card_view);

        lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(new CustomAdapter(this, prgmNameList,prgmDetailList, prgmImages));
        lv.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {

                if (position == 0) {

                    Intent i1 = new Intent(MainActivity.this, Second_Activity.class);

                    int address = R.raw.aa;
                    int img_address = R.drawable.aarti_ganeshji;
                    i1.putExtra("song_address", address);
                    i1.putExtra("Image_Address",img_address);
                    startActivity(i1);

                }
                if (position == 1) {

                    Intent i1 = new Intent(MainActivity.this, Second_Activity.class);

                    int address = R.raw.bb;
                    int img_address = R.drawable.aarti_shivji;
                    i1.putExtra("song_address", address);
                    i1.putExtra("Image_Address",img_address);
                    startActivity(i1);

                }
                if (position == 2) {

                    Intent i1 = new Intent(MainActivity.this, Second_Activity.class);

                    int address = R.raw.cc;
                    int img_address = R.drawable.aarti_hanumanji;
                    i1.putExtra("song_address", address);
                    i1.putExtra("Image_Address",img_address);
                    startActivity(i1);

                }
                if (position == 3) {

                    Intent i1 = new Intent(MainActivity.this, Second_Activity.class);

                    int address = R.raw.ee;
                    int img_address = R.drawable.aarti_krishnaji;
                    i1.putExtra("song_address", address);
                    i1.putExtra("Image_Address",img_address);
                    startActivity(i1);

                }
                if (position == 4) {

                    Intent i1 = new Intent(MainActivity.this, Second_Activity.class);

                    int address = R.raw.dd;
                    int img_address = R.drawable.aarti_saibaba;
                    i1.putExtra("song_address", address);
                    i1.putExtra("Image_Address",img_address);
                    startActivity(i1);

                }
                if (position == 5) {

                    Intent i1 = new Intent(MainActivity.this, Second_Activity.class);

                    int address = R.raw.ff;
                    int img_address = R.drawable.aarti_vishnuji;
                    i1.putExtra("song_address", address);
                    i1.putExtra("Image_Address",img_address);
                    startActivity(i1);

                }
                if (position == 6) {

                    Intent i1 = new Intent(MainActivity.this, Second_Activity.class);

                    int address = R.raw.gg;
                    int img_address = R.drawable.aarti_sherawaliji;
                    i1.putExtra("song_address", address);
                    i1.putExtra("Image_Address",img_address);
                    startActivity(i1);

                }
                if (position == 7) {

                    Intent i1 = new Intent(MainActivity.this, Second_Activity.class);

                    int address = R.raw.hh;
                    int img_address = R.drawable.aarti_laxmiji;
                    i1.putExtra("song_address", address);
                    i1.putExtra("Image_Address",img_address);
                    startActivity(i1);

                }
                if (position == 8) {

                    Intent i1 = new Intent(MainActivity.this, Second_Activity.class);

                    int address = R.raw.ii;
                    int img_address = R.drawable.aarti_shanidevji;
                    i1.putExtra("song_address", address);
                    i1.putExtra("Image_Address",img_address);
                    startActivity(i1);

                }
            }
        });


    }
    @Override
    protected void onDestroy() {
        super.onDestroy();

        NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        manager.cancel(notinum);
        stopService(new Intent(getBaseContext(), ServicetoPlay.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    //code for share app link via any option
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.share:
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject here");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=com.aarti.hmp.app.aarti");
                startActivity(Intent.createChooser(shareIntent, "share via"));
                break;
            default:
                break;

        }
        return true;
    }



}
