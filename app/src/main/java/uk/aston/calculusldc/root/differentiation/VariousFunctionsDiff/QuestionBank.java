package uk.aston.calculusldc.root.differentiation.VariousFunctionsDiff;

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
            {"(5x^2 + 6)*sin(4*x^2 + 6x + 5)","(8x + 6)*cos(4*x^2 + 6x + 5)" ,  "-10*x^(-11) + 30*x^9",  "sin(4*x^2 + 6x + 5)"},
            {"6*sin(2x) + 30*cos(3x)", "2*(3*x^2 + 5)^(-1.5)*x^2",  "(3x + 5)^(-1.5)x^3", "(5x + 5)^(-2.5)x^3"},
            {"7.5*(5*x^3 + 2)^(-0.5)*x^2", "32*e^(4x) - 35*cos(7x)",  "5.5*(6*x^6 + 2)^(-1.5)*x^6", "5*(2*x^6 + 2)^(-0.5)*x^2"},
            {"(4x + 9)*cos(2*x^2 + 9x + 8)", "sin(2*x^2 + 10x)",  "8*x^(-2) + 90*x^8", "(8x + 10)*sin(4*x^3 + 11x + 3)"},

    };

    //Array of correct answers
    private String mCorrectAnswers[] = {"-10*x^(-11) + 30*x^9", "6*sin(2x) + 30*cos(3x)", "32*e^(4x) - 35*cos(7x)", "-8*x^(-2) + 90*x^8"};


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