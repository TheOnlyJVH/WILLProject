package com.higher.login_register_home;

import java.util.List;

public class QuestAndAns
{

    String question;
    int answer;
    List<Double> wrongAnswers;

    public QuestAndAns()
    {
    }

    public String getQuestion()
    {
        return question;
    }

    public int getAnswer()
    {
        return answer;
    }

    public List<Double> getWrongAnswers()
    {
        return wrongAnswers;
    }

    public void setQuestion(String question)
    {
        this.question = question;
    }

    public void setAnswer(int answer)
    {
        this.answer = answer;
    }

    public void setWrongAnswers(List<Double> wrongAnswers)
    {
        this.wrongAnswers = wrongAnswers;
    }
}
