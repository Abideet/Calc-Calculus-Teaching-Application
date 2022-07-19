package uk.aston.calculusldc.root.differentiation.ProductRule;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.ui.AppBarConfiguration;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import uk.aston.calculusldc.MainActivity;
import uk.aston.calculusldc.R;
import uk.aston.calculusldc.root.differentiation.ChainRule.ChainRuleFragment;
import uk.aston.calculusldc.root.differentiation.SavedFragment;
import uk.aston.calculusldc.root.differentiation.SearchFragment;

public class HighestScoreActivity extends AppCompatActivity {

    TextView currentScore;
    TextView highScore;
    Button repeat;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highest_score_chain_rule);

        currentScore = findViewById(R.id.textScore);
        highScore = findViewById(R.id.textHighScore);
        // receive the score from last activity by Intent
        Intent intent = getIntent();
        int score = intent.getIntExtra("score", 0);
        // display current score
        currentScore.setText("Your score: " + score);

        // use Shared preferences to save the best score
        SharedPreferences mypref = getPreferences(MODE_PRIVATE);
        int highscore = mypref.getInt("highscore",0);
        if(highscore>= score)
            highScore.setText("High score: "+highscore);
        else
        {
            //update the highscore in shared pref
            highScore.setText("New highscore: "+score);
            SharedPreferences.Editor editor = mypref.edit();
            editor.putInt("highscore", score);
            editor.commit();
        }

        //buttons
        repeat = findViewById(R.id.buttonRepeat);
        back = findViewById(R.id.buttonBack);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.homeFragment, R.id.searchFragment)
                .build();

        BottomNavigationView navView = findViewById(R.id.highScoreNav);
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {

                    case R.id.searchFragment:
//                        startActivity(new Intent(getApplicationContext(), SearchFragment.class));
//                        overridePendingTransition(0,0);
                        Fragment searchFragment = new SearchFragment();
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                        transaction.replace(R.id.activity_quiz, searchFragment);
                        transaction.addToBackStack(null);

                        currentScore.setVisibility(View.GONE);
                        highScore.setVisibility(View.GONE);
                        repeat.setVisibility(View.GONE);
                        back.setVisibility(View.GONE);


                        return true;
                    case R.id.savedFragment:

                        Fragment savedFragment = new SavedFragment();
                        FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();

                        transaction1.replace(R.id.activity_quiz, savedFragment);
                        transaction1.addToBackStack(null);

                        currentScore.setVisibility(View.GONE);
                        highScore.setVisibility(View.GONE);
                        repeat.setVisibility(View.GONE);
                        back.setVisibility(View.GONE);


                        transaction1.commit();
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
        Intent intent = new Intent(HighestScoreActivity.this, QuizActivity.class);
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

