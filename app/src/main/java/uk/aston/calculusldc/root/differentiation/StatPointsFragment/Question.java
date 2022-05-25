package uk.aston.calculusldc.root.differentiation.StatPointsFragment;

import com.agog.mathdisplay.MTMathView;

// class Question to describe on question for test:
// question itself, multiple choices to answer, and correct answer
public class Question {

    private MTMathView questionNotations;
    private String[] userChoice = new String[4];
    private String answer;

    public Question() {

    }
    public Question(MTMathView question, String[] choices, String answer) {
        this.questionNotations = question;
        this.userChoice[0] = choices[0];
        this.userChoice[1] = choices[1];
        this.userChoice[2] = choices[2];
        this.userChoice[3] = choices[3];
        this.answer = answer;
    }

    public String getQuestion() {
        String questionString = questionNotations.toString();

        return questionString;
    }

    public String getChoice(int i) {
        return userChoice[i];
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setChoice(int i, String choice) {
        this.userChoice[i] = choice;
    }

    public void setQuestion(MTMathView question) {
        this.questionNotations = question;
    }
}
