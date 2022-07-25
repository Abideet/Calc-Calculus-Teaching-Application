package uk.aston.calculusldc.root.differentiation.StatPointsFragment;

// This class contains a list of questions

import android.app.Activity;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class QuizInventory
{

    private Context context;
    Activity activity;

    // declare list of Question objects
    List <Question> list = new ArrayList<>();


    private final String [] textQuestions =
            {
            "question 1",
            "question 2",
            "question 3",
            "question 4",
    };



    private final String[][] multipleChoice =
            {
            {"(-5,283) (2,-60)","(-6,134) (2,-15)" ,  "(-4,142) (3,-65)",  "(-4,234) (2,-48)"},
            {"(-5,520) (2,-215)", "(-5,424) (4,-305)",  "(-7,254) (5,-444)", "(-3,317) (6,-254)"},
            {"(-10,243) (2,-15)", "(-6,317) (1,-26)",  "(-3,113) (1,-43)", "(-6,313) (1,-32)"},
            {"(-3,90) (2,-35)", "(-3,89) (1,-20)",  "(-2,99) (3,-10)", "(-2,90) (1,-14)"},

    };

    //Array of correct answers
    private final String[] mCorrectAnswers = {"(-5,283) (2,-60)", "(-5,424) (4,-305)", "(-6,317) (1,-26)", "(-3,90) (2,-35)"};


    // method returns number of questions in list
    public int getLength(){
        return textQuestions.length;
    }


    // method return a single multiple choice item for question based on list index,
    // based on number of multiple choice item in the list - 1, 2, 3 or 4
    // as an argument
    public String getChoice(int index, int num) {
        //return list.get(index).getChoice(num-1);
        //num - 1 so index is not out of bounds
        String choice = multipleChoice[index][num - 1];
        return choice;
    }

    //  method returns correct answer for the question based on list index
    public String getCorrectAnswer(int a) {
        //return list.get(a).getAnswer();
        String answer = mCorrectAnswers[a];
        return answer;
    }



}