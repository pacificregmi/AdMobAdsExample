package np.com.pacificregmi.admob.example.tutorial.ads;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    private AdView mAdView;

    private Button mInterstitialImageTextButton;
    private Button mInterstitialVideoButton;
    private Button mTopBannerAdButton;
    private Button mBottomBannerAdButton;
    private Button mLargeBannerAdButton;
    private Button mMediumRectangleBannerAd;
    private Button mFullSizeBannerAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mInterstitialImageTextButton = ((Button) findViewById(R.id.interstitial_image_text));
        mInterstitialImageTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iinent = new Intent(MainActivity.this, InterstitialImageTextAd.class);
                startActivity(iinent);
            }
        });

        mInterstitialVideoButton = ((Button) findViewById(R.id.interstitial_video));
        mInterstitialVideoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iinent = new Intent(MainActivity.this, RewardedVideoAds.class);
                startActivity(iinent);
            }
        });

        mTopBannerAdButton = ((Button) findViewById(R.id.banner_top_ad));
        mTopBannerAdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iinent = new Intent(MainActivity.this, BannerTopAd.class);
                startActivity(iinent);
            }
        });

        mBottomBannerAdButton = ((Button) findViewById(R.id.banner_bottom_ad));
        mBottomBannerAdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iinent = new Intent(MainActivity.this, BannerBottomAd.class);
                startActivity(iinent);
            }
        });

        mLargeBannerAdButton = ((Button) findViewById(R.id.large_banner_ad));
        mLargeBannerAdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iinent = new Intent(MainActivity.this, LargeBannerAd.class);
                startActivity(iinent);
            }
        });

        mMediumRectangleBannerAd = ((Button) findViewById(R.id.medium_banner_ad));
        mMediumRectangleBannerAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iinent = new Intent(MainActivity.this, MediumRectangleBannerAd.class);
                startActivity(iinent);
            }
        });

        mFullSizeBannerAd = ((Button) findViewById(R.id.full_size_banner_ad));
        mFullSizeBannerAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iinent = new Intent(MainActivity.this, FullSizeBannerAd.class);
                startActivity(iinent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
