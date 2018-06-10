package np.com.pacificregmi.admob.example.tutorial.ads;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class InterstitialImageTextAd extends AppCompatActivity {

    private AdView mAdView;
    private static final int START_LEVEL = 1;
    private int mLevel;
    private Button mInterstitialImageTextButton;
    private InterstitialAd mInterstitialAdImageText;
    private TextView mLevelTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interstitial_ads_image_text);

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mInterstitialImageTextButton = ((Button) findViewById(R.id.interstitial_image_text));
       // mInterstitialImageTextButton.setEnabled(false);
        mInterstitialImageTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInterstitialImageText();
            }
        });

        // Create the text view to show the level number.
        mLevelTextView = (TextView) findViewById(R.id.level);
        mLevel = START_LEVEL;

        // Create the InterstitialAd and set the adUnitId (defined in values/strings.xml).
        mInterstitialAdImageText = newInterstitialAdImageText();
        loadInterstitialImageText();

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

    private InterstitialAd newInterstitialAdImageText() {
        InterstitialAd interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                mInterstitialImageTextButton.setEnabled(true);
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                mInterstitialImageTextButton.setEnabled(true);
            }

            @Override
            public void onAdClosed() {
                // Proceed to the next level.
                goToNextLevelInterstitialImageText();
            }
        });
        return interstitialAd;
    }

    private void showInterstitialImageText() {
        // Show the ad if it's ready. Otherwise toast and reload the ad.
        if (mInterstitialAdImageText != null && mInterstitialAdImageText.isLoaded()) {
            mInterstitialAdImageText.show();
        } else {
            Toast.makeText(this, "Ad did not load", Toast.LENGTH_SHORT).show();
            goToNextLevelInterstitialImageText();
        }
    }

    private void loadInterstitialImageText() {
        // Disable the next level button and load the ad.
        mInterstitialImageTextButton.setEnabled(false);
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        mInterstitialAdImageText.loadAd(adRequest);
    }

    private void goToNextLevelInterstitialImageText() {
        // Show the next level and reload the ad to prepare for the level after.
        mLevelTextView.setText("Level " + (++mLevel));
        mInterstitialAdImageText = newInterstitialAdImageText();
        loadInterstitialImageText();
    }
}
