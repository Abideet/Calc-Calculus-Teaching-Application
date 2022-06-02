package uk.aston.calculusldc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.widget.Toast;

//import com.google.android.exoplayer2.SimpleExoPlayer;
//import com.google.android.exoplayer2.util.Util;
//import com.google.android.exoplayer2.ExoPlayer;
//
//import com.google.android.exoplayer2.upstream.BandwidthMeter;
//import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
//import com.google.android.exoplayer2.upstream.DefaultHttpDataSource;
//
//import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
//import com.google.android.exoplayer2.extractor.ExtractorsFactory;
//import com.google.android.exoplayer2.source.MediaSource;
//import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
//import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
//import com.google.android.exoplayer2.trackselection.TrackSelector;
//import com.google.android.exoplayer2.ui.PlayerView;
//import com.google.android.exoplayer2.upstream.BandwidthMeter;
//import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
//import com.google.android.youtube.player.YouTubeInitializationResult;
//import com.google.android.youtube.player.YouTubePlayer;
//import com.google.android.youtube.player.YouTubePlayerView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity
{

    String api_key = "AIzaSyCmRJznAFXy952HYqbjKVEFHTsR-HIIHyc";

    // creating a variable for our Firebase Database.
    FirebaseDatabase firebaseDatabase;

    // creating a variable for our Database
    // Reference for Firebase.
    DatabaseReference databaseReference;

    // creating a variable for exoplayerview.
    //PlayerView exoPlayerView;

    // creating a variable for exoplayer
    //ExoPlayer exoPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // below line is used to get the
        // instance of our Firebase database.
        firebaseDatabase = FirebaseDatabase.getInstance();

        // below line is used to get reference for our database.
        databaseReference = firebaseDatabase.getReference("url");
        getVideoUrl();

        BottomNavigationView navView = findViewById(R.id.nav);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.homeFragment, R.id.searchFragment)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.fContainer);
        NavigationUI.setupWithNavController(navView, navController);
        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

    }

    private void getVideoUrl() {
        // calling add value event listener method
        // for getting the values from database.
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // this method is call to get the
                // realtime updates in the data.
                // this method is called when the
                // data is changed in our Firebase console.
                // below line is for getting the data
                // from snapshot of our database.
                String videoUrl = snapshot.getValue(String.class);

                // after getting the value for our video url
                // we are passing that value to our
                // initialize exoplayer method to load our video
                //initializeExoplayerView(videoUrl);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {
                // calling on cancelled method when we receive
                // any error or we are not able to get the data.
                Toast.makeText(MainActivity.this, "Fail to get video url.", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
