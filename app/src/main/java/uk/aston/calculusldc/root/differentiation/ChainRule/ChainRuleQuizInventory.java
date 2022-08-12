package uk.aston.calculusldc.root.differentiation.ChainRule;



public class ChainRuleQuizInventory
{


    private final String [] questionNumbers =
            {
            "1",
            "2",
            "3",
            "4",
    };



    private final String[][] answers =
            {
            {"(5x^2 + 6)*sin(4*x^2 + 6x + 5)","(8x + 6)*cos(4*x^2 + 6x + 5)" ,  "cos(4*x^2 + 6x + 5)",  "sin(4*x^2 + 6x + 5)"},
            {"5*(2*x^5 + 4)^(-0.5)*x^4", "2*(3*x^2 + 5)^(-1.5)*x^2",  "(3x + 5)^(-1.5)x^3", "(5x + 5)^(-2.5)x^3"},
            {"7.5*(5*x^3 + 2)^(-0.5)*x^2", "1.5*(6*x^4 + 2)^(-4.5)*x^3",  "5.5*(6*x^6 + 2)^(-1.5)*x^6", "5*(2*x^6 + 2)^(-0.5)*x^2"},
            {"(4x + 9)*cos(2*x^2 + 9x + 8)", "sin(2*x^2 + 10x)",  "(3x + 10)*sin(4*x^2 + 9x + 10)", "(8x + 10)*sin(4*x^3 + 11x + 3)"},
    };

    //Array of correct answers
    private final String[] correctAnswers = {"(8x + 6)*cos(4*x^2 + 6x + 5)", "5*(2*x^5 + 4)^(-0.5)*x^4", "7.5*(5*x^3 + 2)^(-0.5)*x^2", "(4x + 9)*cos(2*x^2 + 9x + 8)"};


    // method returns number of questions in list
    public int getLength(){
        return questionNumbers.length;
    }


    public String getChoice(int index, int num)
    {
        String choice = answers[index][num - 1];
        return choice;
    }

    public String getCorrectAnswer(int a)
    {
        String answer = correctAnswers[a];
        return answer;
    }

}

















































