package uk.aston.calculusldc.root.differentiation.ProductRule;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import uk.aston.calculusldc.MainActivity;
import uk.aston.calculusldc.R;
import uk.aston.calculusldc.root.differentiation.ChainRule.ChainRuleVidActivity;
import uk.aston.calculusldc.root.differentiation.SearchFragment;

public class ProductRuleVidActivity extends YouTubeBaseActivity
{

    ImageButton b1;

    private YouTubePlayerView youtubeView1;

    //listener that allows us to play videos, cue them, pause them
    private YouTubePlayer.OnInitializedListener onInitializedListener1;


    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_productrulevideo);

        youtubeView1 = findViewById(R.id.yVideoProductRule);

        onInitializedListener1 = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                //chain rule youtube vid
                //youTubePlayer.loadVideo("2Cx9LnoUexg");

                //
                youTubePlayer.loadVideo("TFvVPdKZ-_E");


            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        b1 = findViewById(R.id.buttonProductRule);
        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                youtubeView1.initialize("AIzaSyAk7eeNLkUH3nUbf83fV-4XGQjdV0e61JQ", onInitializedListener1);
            }
        });


        BottomNavigationView navView = findViewById(R.id.productRuleNav);

        //navView.setSelectedItemId(R.id.homeFragment);

        // Perform item selected listener
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.searchFragment:


                        return true;
                    case R.id.homeFragment:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });


    }

}
