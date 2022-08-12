package uk.aston.calculusldc.root.differentiation.QuotientRule;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import uk.aston.calculusldc.MainActivity;
import uk.aston.calculusldc.R;
import uk.aston.calculusldc.root.InteractiveDiagrams.InteractiveDiagramCalculatorActivity;
import uk.aston.calculusldc.root.differentiation.ChainRule.ChainRuleFragment;
import uk.aston.calculusldc.root.differentiation.ChainRule.ChainRuleQuestionActivity;

public class QuotientRuleBestScoreActivity extends AppCompatActivity {

    TextView currentScore;
    TextView highScore;
    Button repeat;



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
        int score = intent.getIntExtra("score", 0);
        // display current score
        currentScore.setText("Your score: " + score);

        // use Shared preferences to save the best score
        SharedPreferences mypref = getPreferences(MODE_PRIVATE);
        int highscore = mypref.getInt("Chain Rule",0);

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


        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.homeFragment, R.id.graphCalculateFragment)
                .build();

        BottomNavigationView navView = findViewById(R.id.highScoreNav);

        //navView.setSelectedItemId(R.id.homeFragment);

        // Perform item selected listener
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {

                    case R.id.graphCalculateFragment:
                        startActivity(new Intent(getApplicationContext(), InteractiveDiagramCalculatorActivity.class));
                        overridePendingTransition(0,0);

                        return true;
                    case R.id.savedFragment:

                        fragment.setVisibility(View.VISIBLE);
                        currentScore.setVisibility(View.GONE);
                        highScore.setVisibility(View.GONE);


                        NavController navController2 = Navigation.findNavController(QuotientRuleBestScoreActivity.this,R.id.fContainerHighScore);
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
        Intent intent = new Intent(QuotientRuleBestScoreActivity.this, QuotientRuleQuestionActivity.class);
        startActivity(intent);
    }



}
