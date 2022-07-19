package uk.aston.calculusldc.root.differentiation.QuotientRule;

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


    private final String [] textQuestions =
            {
            "question 1",
            "question 2",
            "question 3",
            "question 4",
    };



    private final String[][] multipleChoice =
            {
            {"55/(2x + 8)^2", "44/(6x + 8)^2",  "10/(3x + 10)^3",  "4/(16x + 9)^2"},
            {"(-3*sin(3x)*sin(4x) - 4*cos(3x)*cos(4x))/sin(4x)^2", "(-6*sin(6x)*sin(8x) - 10*cos(2x)*cos(5x))/sin(4x)^2",  "(-4*cos(3x)*cos(4x) - 4*sin(3x)*sin(4x))/cos(4x)^2", "(-10*sin(10x)*sin(8x) - 4*cos(3x)*cos(4x))/sin(4x)^2"},
            {"(1/x - 5*ln(4x))/e^(5x)", "(2/x - 6*ln(6x))/e^(5x)",  "(1/x - 4*ln(3x))/e^(4x)", "(1/x - 8*ln(5x))/e^(8x)"},
            {"-4/(3x + 5)^2", "-6/(3x + 6)^2",  "-3/(4x + 6)^2", "-3/(4x + 10)^2"},

    };

    //Array of correct answers
    private final String[] mCorrectAnswers = {"44/(6x + 8)^2", "(-3*sin(3x)*sin(4x) - 4*cos(3x)*cos(4x))/sin(4x)^2", "(1/x - 5*ln(4x))/e^(5x)", "-4/(3x + 5)^2"};


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