package uk.aston.calculusldc.root.differentiation.PartialDiff;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.ui.AppBarConfiguration;

import uk.aston.calculusldc.R;
import uk.aston.calculusldc.root.differentiation.ChainRule.ChainRuleFragment;
import uk.aston.calculusldc.root.differentiation.ProductRule.QuizActivity;

public class HighestScoreActivity extends AppCompatActivity {

    TextView currentScore;
    TextView highScore;
    Button repeat;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highest_score_chain_rule);

        currentScore = (TextView) findViewById(R.id.textScore);
        highScore = (TextView) findViewById(R.id.textHighScore);
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

