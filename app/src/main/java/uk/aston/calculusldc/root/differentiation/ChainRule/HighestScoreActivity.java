package uk.aston.calculusldc.root.differentiation.ChainRule;

import static android.content.ContentValues.TAG;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import uk.aston.calculusldc.MainActivity;
import uk.aston.calculusldc.R;
import uk.aston.calculusldc.root.Database.Score;
import uk.aston.calculusldc.root.Database.ScoreViewModel;
import uk.aston.calculusldc.root.differentiation.SavedFragment;
import uk.aston.calculusldc.root.differentiation.SearchFragment;

public class HighestScoreActivity extends AppCompatActivity {

    TextView currentScore;
    TextView highScore;
    Button repeat;
    Button back;

    public int score;
    public int highscore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highest_score_chain_rule);

        currentScore = findViewById(R.id.textScore);
        highScore = findViewById(R.id.textHighScore);

        // receive the score from last activity by Intent

        View fragment = findViewById(R.id.fContainerHighScore);
        fragment.setVisibility(View.INVISIBLE);

        Intent intent = getIntent();
        score = intent.getIntExtra("score", 0);
        // display current score
        currentScore.setText("Your score: " + score);

        //int highscore = Integer.parseInt(highScore.toString());

        // use Shared preferences to save the best score
        SharedPreferences mypref = getPreferences(MODE_PRIVATE);
        highscore = mypref.getInt("Chain Rule",0);




        if(highscore>= score)
            highScore.setText("High score: "+highscore);

        else
        {
            //update the highscore in shared pref
            highScore.setText("New highscore: "+score);


            SharedPreferences.Editor editor = mypref.edit();
            editor.putInt("Chain Rule", score);
            editor.commit();


        }

        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor mEditor = mPreferences.edit();
        mEditor.putInt("highScore", highscore);
        mEditor.commit();



        //buttons
        repeat = findViewById(R.id.buttonRepeat);
        back = findViewById(R.id.buttonBack);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.homeFragment, R.id.searchFragment)
                .build();

        BottomNavigationView navView = findViewById(R.id.highScoreNav);

        //navView.setSelectedItemId(R.id.homeFragment);

        // Perform item selected listener
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {

                    case R.id.searchFragment:
                        fragment.setVisibility(View.VISIBLE);
                        currentScore.setVisibility(View.GONE);
                        highScore.setVisibility(View.GONE);
                        repeat.setVisibility(View.GONE);
                        back.setVisibility(View.GONE);

                        NavController navController = Navigation.findNavController(HighestScoreActivity.this,R.id.fContainerHighScore);
                        navController.navigateUp();
                        navController.navigate( R.id.searchFragment2);

                        return true;
                    case R.id.savedFragment:

                        fragment.setVisibility(View.VISIBLE);
                        currentScore.setVisibility(View.GONE);
                        highScore.setVisibility(View.GONE);
                        repeat.setVisibility(View.GONE);
                        back.setVisibility(View.GONE);

                        NavController navController2 = Navigation.findNavController(HighestScoreActivity.this,R.id.fContainerHighScore);
                        navController2.navigateUp();
                        navController2.navigate( R.id.savedFragment2);

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


    public void onRepeatClick(View view)
    {
        Intent intent = new Intent(HighestScoreActivity.this, uk.aston.calculusldc.root.differentiation.ChainRule.QuizActivity.class);
        startActivity(intent);
    }


    public void onBackClick(View view)
    {
        currentScore.setVisibility(View.GONE);
        highScore.setVisibility(View.GONE);
        repeat.setVisibility(View.GONE);
        back.setVisibility(View.GONE);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_highest_score, new ChainRuleFragment()).commit();
    }
}

