package uk.aston.calculusldc.root.differentiation.ChainRule;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.agog.mathdisplay.MTMathView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.StringTokenizer;

import uk.aston.calculusldc.MainActivity;
import uk.aston.calculusldc.R;
import uk.aston.calculusldc.root.Database.Score;
import uk.aston.calculusldc.root.Database.ScoreViewModel;
import uk.aston.calculusldc.root.differentiation.SavedFragment;
import uk.aston.calculusldc.root.differentiation.SearchFragment;

public class QuizActivity extends AppCompatActivity
{

    private final QuizInventory mQuestionLibrary = new QuizInventory();

    private TextView mScoreView;   // view for current total score
    private TextView mScoreTextView;
    private MTMathView mQuestionView;  //current question to answer
    private MTMathView mQuestionView1;  //current question to answer
    private TextView mQuestionText;
    private Button mButtonChoice1; // multiple choice 1 for mQuestionView
    private Button mButtonChoice2; // multiple choice 2 for mQuestionView
    private Button mButtonChoice3; // multiple choice 3 for mQuestionView
    private Button mButtonChoice4; // multiple choice 4 for mQuestionView

    Double score;

    private MTMathView mAnswerView;

    private String mAnswer;  // correct answer for question in mQuestionView
    private int mScore = 0;  // current total score
    public int mQuestionNumber = 0; // current question number

    private ScoreViewModel mScoreViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mScoreView = findViewById(R.id.score);
        mQuestionView = findViewById(R.id.question);
        mScoreTextView = findViewById(R.id.score_text);

        mQuestionText = findViewById(R.id.questionText);
        mQuestionText.setText("Differentiate the following function with respect to x using the chain rule & select the correct answer.");


        mButtonChoice1 = findViewById(R.id.choice1);
        mButtonChoice1.setText("hello");

        mButtonChoice2 = findViewById(R.id.choice2);
        mButtonChoice3 = findViewById(R.id.choice3);
        mButtonChoice4 = findViewById(R.id.choice4);


        updateQuestion();
        // show current total score for the user
        updateScore(mScore);


        mQuestionView.setLatex("$y = sin(4x^2+6x+5)");
        mQuestionView.setFontSize(70);


        BottomNavigationView navView = findViewById(R.id.quizNav);

        mScoreViewModel = ViewModelProviders.of(this).get(ScoreViewModel.class);


        //navView.setSelectedItemId(R.id.homeFragment);

        // Perform item selected listener
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {

                    case R.id.searchFragment:

                        Fragment searchFragment = new SearchFragment();
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                        transaction.replace(R.id.activity_quiz, searchFragment);
                        transaction.addToBackStack(null);

                        mScoreView.setVisibility(View.GONE);
                        mScoreTextView.setVisibility(View.GONE);
                        mQuestionView.setVisibility(View.GONE);
                        mButtonChoice1.setVisibility(View.GONE);
                        mButtonChoice2.setVisibility(View.GONE);
                        mButtonChoice3.setVisibility(View.GONE);
                        mButtonChoice4.setVisibility(View.GONE);

                        transaction.commit();

                        return true;
                    case R.id.savedFragment:

                        Fragment savedFragment = new SavedFragment();
                        FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();

                        transaction1.replace(R.id.activity_quiz, savedFragment);
                        transaction1.addToBackStack(null);

                        mScoreView.setVisibility(View.GONE);
                        mScoreTextView.setVisibility(View.GONE);
                        mQuestionView.setVisibility(View.GONE);
                        mQuestionText.setVisibility(View.GONE);
                        mButtonChoice1.setVisibility(View.GONE);
                        mButtonChoice2.setVisibility(View.GONE);
                        mButtonChoice3.setVisibility(View.GONE);
                        mButtonChoice4.setVisibility(View.GONE);

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

    private void updateQuestion(){
        // check if we are not outside array bounds for questions
        if(mQuestionNumber<mQuestionLibrary.getLength() ){
            // set the text for new question,
            // and new 4 alternative to answer on four buttons
            //mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));

            //mQuestionView.setLatex(mQuestionLibrary.getQuestion(mQuestionNumber).toString());

            if(mQuestionNumber == 1)
            {
                mQuestionView1 = findViewById(R.id.question);
                mQuestionView1.setLatex("$y = \\sqrt{2x^5 + 4}");
                mQuestionView1.setFontSize(70);
            }
            else if (mQuestionNumber == 2)
            {

                mQuestionView1.setLatex("$y = \\sqrt{5x^3 + 2}");

            } else if (mQuestionNumber == 3)
            {
                mQuestionView1.setLatex("$y = sin(4x^2+6x+5)");
            }

            mButtonChoice1.setText(mQuestionLibrary.getChoice(mQuestionNumber, 1));
            mButtonChoice2.setText(mQuestionLibrary.getChoice(mQuestionNumber, 2));
            mButtonChoice3.setText(mQuestionLibrary.getChoice(mQuestionNumber, 3));
            mButtonChoice4.setText(mQuestionLibrary.getChoice(mQuestionNumber,4));
            mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
            mQuestionNumber++;
       }
        else {
            Toast.makeText(QuizActivity.this, "It was the last question!", Toast.LENGTH_SHORT).show();



            Score score = new Score();
            score.setmTopic("Chain Rule");

            String scoreString = mScoreView.getText().toString();
            double scoreDouble = scoreStringtoDoubleConverter(scoreString);

            score.setMscore(scoreDouble);


            int highScore;

            SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = mPreferences.edit();

            highScore = mPreferences.getInt("highScore",0);


            try
            {

                mScoreViewModel.insert(score);

                //if the score just achieved is higher than the high score, update it
                if(scoreDouble >= highScore)
                {

                    mScoreViewModel.update(score);
                }
                Log.d(TAG,"insertion worked");
            }catch(SQLiteConstraintException e){
                Log.d(TAG, "insertion failed");
            }


            //switch to new activity
            Intent intent = new Intent(QuizActivity.this, HighestScoreActivity.class);
            intent.putExtra("score", mScore); // pass the current score to the second screen
            startActivity(intent);
        }
    }



    // show current total score for the user
    private void updateScore(int point)
    {
        mScoreView.setText(""+mScore+"/"+mQuestionLibrary.getLength());
    }

    public void onClick(View view)
    {
        //all logic for all answers buttons in one method
        Button answer = (Button) view;
        // if the answer is correct, increase the score
        if (answer.getText().equals(mAnswer))
        {
            mScore = mScore + 1;
             Toast.makeText(QuizActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
        }else
            Toast.makeText(QuizActivity.this, "Wrong!", Toast.LENGTH_SHORT).show();
        // show current total score for the user
        updateScore(mScore);
        // once user answer the question, we move on to the next one, if any
        updateQuestion();
    }

    public Double scoreStringtoDoubleConverter(String scoreString)
    {
        StringTokenizer tokenizer = new StringTokenizer(scoreString, "/");
        score = Double.parseDouble(tokenizer.nextToken());



        return score;
    }



}