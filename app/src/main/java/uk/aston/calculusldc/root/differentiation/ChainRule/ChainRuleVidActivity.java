package uk.aston.calculusldc.root.differentiation.ChainRule;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatCallback;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import uk.aston.calculusldc.MainActivity;
import uk.aston.calculusldc.R;
import uk.aston.calculusldc.root.differentiation.SavedFragment;
import uk.aston.calculusldc.root.differentiation.SearchFragment;

public class ChainRuleVidActivity extends YouTubeBaseActivity implements AppCompatCallback
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

        AppCompatDelegate delegate = AppCompatDelegate.create(this, this);
        delegate.onCreate(bundle);
        delegate.setContentView(R.layout.activity_chainrulevideo);


        youtubeView1 = findViewById(R.id.yVideo1);
        youtubeView2 = findViewById(R.id.yVideo2);
        youtubeView3 = findViewById(R.id.yVideo3);


        //Video 1
        onInitializedListener1 = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

                //
                youTubePlayer.loadVideo("bKY2EmmdkXo");
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
                youTubePlayer.loadVideo("2Cx9LnoUexg");

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


        //Video3
        onInitializedListener3 = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b)
            {
                //chain rule youtube vid
                //youTubePlayer.loadVideo("2Cx9LnoUexg");

                //
                youTubePlayer.loadVideo("HjddQzdcSek");

                //
                //youTubePlayer.loadVideo("-QezMBY0Ndk");

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

        BottomNavigationView navView = findViewById(R.id.chainRuleNav);

        navView.setSelectedItemId(R.id.homeFragment);

        // Perform item selected listener
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {

                    case R.id.searchFragment:
//                        startActivity(new Intent(getApplicationContext(), SearchFragment.class));
//                        overridePendingTransition(0,0);


                        return true;
                    case R.id.savedFragment:



                        youtubeView1.setVisibility(View.GONE);
                        youtubeView2.setVisibility(View.GONE);
                        youtubeView3.setVisibility(View.GONE);
                        b1.setVisibility(View.GONE);
                        b2.setVisibility(View.GONE);
                        b3.setVisibility(View.GONE);

                        return true;
                    case R.id.homeFragment:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });


        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.homeFragment, R.id.searchFragment)
//                .build();
        //NavController navController = Navigation.findNavController(this, R.id.chainVidFragment);
        //NavigationUI.setupWithNavController(navView, navController);
        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onPostResume() {
        super.onPostResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }







    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onSupportActionModeStarted(ActionMode mode) {

    }

    @Override
    public void onSupportActionModeFinished(ActionMode mode) {

    }

    @Nullable
    @Override
    public ActionMode onWindowStartingSupportActionMode(ActionMode.Callback callback) {
        return null;
    }
}
