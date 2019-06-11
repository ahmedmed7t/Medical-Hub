package com.example.crazynet.medicalhub.Model;

/**
 * Created by Medhat on 11/06/2019.
 */

public class AnsweredQuestion {

    private String Question;
    private String Answer;

    public AnsweredQuestion() {
    }

    public AnsweredQuestion(String question, String answer) {

        Question = question;
        Answer = answer;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }
}
