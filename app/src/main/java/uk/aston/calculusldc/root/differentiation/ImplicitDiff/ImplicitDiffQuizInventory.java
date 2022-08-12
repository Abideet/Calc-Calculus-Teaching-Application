package uk.aston.calculusldc.root.differentiation.ImplicitDiff;


public class ImplicitDiffQuizInventory
{


    private final String [] questionNumbers =
            {
            "1",
            "2",
            "3",
            "4",
    };



    private final String[][] multipleChoice =
            {
            {"(6 - 2x - 2y)/(2 + 2y + 2x)","(8x + 6)*cos(4*x^2 + 6x + 5)" ,  "(8 - 2x - 2y)/(4 + 8y + 8x)",  "sin(4*x^2 + 6x + 5)"},
            {"5*(2*x^5 + 4)^(-0.5)*x^4", "(3 - 2x + 3y)/(7 + 2y - 3x)",  "(3x + 5)^(-1.5)x^3", "(10 - 2x + 3y)/(11 + 2y - 4x)"},
            {"7.5*(5*x^3 + 2)^(-0.5)*x^2", "(9 - 3x + 2y)/(3 + 4y - x)",  "5.5*(6*x^6 + 2)^(-1.5)*x^6", "(8 - 2x + y)/(3 + 2y - x)"},
            {"(4x + 9)*cos(2*x^2 + 9x + 8)", "(8 - 2x - 2y)/(5 + 2y + 2x)",  "(3x + 10)*sin(4*x^2 + 9x + 10)", "(14 - 2x - 2y)/(9 + 4y + 4x)"},

    };

    //Array of correct answers
    private final String[] mCorrectAnswers = {"(6 - 2x - 2y)/(2 + 2y + 2x)", "(3 - 2x + 3y)/(7 + 2y - 3x)", "(8 - 2x + y)/(3 + 2y - x)", "(8 - 2x - 2y)/(5 + 2y + 2x)"};


    // method returns number of questions in list
    public int getLength(){
        return questionNumbers.length;
    }


    // return a single multiple choice variable
    public String getChoice(int index, int num) {
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