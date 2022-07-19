package uk.aston.calculusldc.root.integration.IntroToIntegration;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import uk.aston.calculusldc.MainActivity;
import uk.aston.calculusldc.R;
import uk.aston.calculusldc.root.differentiation.SearchFragment;

public class IntroToIntegrationVidActivity extends YouTubeBaseActivity
{

    ImageButton b1;
    ImageButton b2;
    ImageButton b3;

    private YouTubePlayerView youtubeView1;
    private YouTubePlayerView youtubeView2;
    private YouTubePlayerView youtubeView3;
    //listener that allows us to play videos, cue them, pause them
    private YouTubePlayer.OnInitializedListener onInitializedListener1;
    private YouTubePlayer.OnInitializedListener onInitializedListener2;
    private YouTubePlayer.OnInitializedListener onInitializedListener3;

    @Override
    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.activity_intro_to_integration_video);

        youtubeView1 = findViewById(R.id.yVideo1);
        youtubeView2 = findViewById(R.id.yVideo2);
        youtubeView3 = findViewById(R.id.yVideo3);

        //Video 1
        onInitializedListener1 = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                //chain rule youtube vid
                //youTubePlayer.loadVideo("2Cx9LnoUexg");

                //
                youTubePlayer.loadVideo("vbr0cs_ZNGs");

                //
                //youTubePlayer.loadVideo("-QezMBY0Ndk");

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        b1 = findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                youtubeView1.initialize("AIzaSyAk7eeNLkUH3nUbf83fV-4XGQjdV0e61JQ", onInitializedListener1);
            }
        });


        //Video2
        onInitializedListener2 = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b)
            {
                //chain rule youtube vid
                //youTubePlayer.loadVideo("2Cx9LnoUexg");

                //
                youTubePlayer.loadVideo("_vHL_WdOyGw");

                //
                //youTubePlayer.loadVideo("-QezMBY0Ndk");

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        b2 = findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                youtubeView2.initialize("AIzaSyAk7eeNLkUH3nUbf83fV-4XGQjdV0e61JQ", onInitializedListener2);
            }
        });


        //Video2
        onInitializedListener3 = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b)
            {

                //
                youTubePlayer.loadVideo("4L58tCEsi10");



            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        b3 = findViewById(R.id.button3);
        b3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                youtubeView3.initialize("AIzaSyAk7eeNLkUH3nUbf83fV-4XGQjdV0e61JQ", onInitializedListener3);
            }
        });

        BottomNavigationView navView = findViewById(R.id.introToIntNav);

        //navView.setSelectedItemId(R.id.homeFragment);

        // Perform item selected listener
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.searchFragment:
                        startActivity(new Intent(getApplicationContext(), SearchFragment.class));
                        overridePendingTransition(0,0);
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
