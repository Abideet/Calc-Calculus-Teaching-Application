package uk.aston.calculusldc.root.differentiation.StatPointsFragment;

// This class contains a list of questions

import android.app.Activity;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class QuestionBank
{

    private Context context;
    Activity activity;

    // declare list of Question objects
    List <Question> list = new ArrayList<>();


    private String [] textQuestions =
            {
            "question 1",
            "question 2",
            "question 3",
            "question 4",
    };



    private String multipleChoice [][] =
            {
            {"-5,279","-8,300" ,  "10,270",  "-5,233"},
            {"7,-396", "4,-296",  "2,296", "7,-116"},
            {"4,-26", "3,-56",  "3,56", "8,-86"},
            {"3,-89", "6,-99",  "7,-29", "1,89"},

    };

    //Array of correct answers
    private String mCorrectAnswers[] = {"-5,279", "4,-296", "7.5*(5*x^3 + 2)^(-0.5)*x^2", "(4x + 9)*cos(2*x^2 + 9x + 8)"};


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