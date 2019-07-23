package kkellum.quizapp;

import android.content.Context;

public class Question {

    private int mTextResId;
    private int mHintTextResId;

    public int getHintTextResId() {
        return mHintTextResId;
    }

    public void setHintTextResId(int hintTextResId) {
        mHintTextResId = hintTextResId;
    }

    public Question(int textResId, int hintTextResId) {
        mTextResId = textResId;
        mHintTextResId = hintTextResId;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public void SetTextResId(int textResId) {
        mTextResId = textResId;
    }

    public String getText(Context ctx)
    {
        return ctx.getString(mTextResId);
    }

    //Stub
    public String getAnswerText(Context ctx)
    {
        return "";
    }

    // stub method - intentionally does nothing
    // only applies to true false question
    public boolean checkAnswer(boolean boolResponse) {
        return false;
    }

    // stub method
    // only applies to fill the blank question
    public boolean checkAnswer(String userAnswer) {
        return false;
    }

    // stub
    public boolean isTrueFalseQuestion()
    {
       return false;
    }

    // stub
    public boolean isFillTheBlankQuestion()
    {
        return false;
    }

    // stub
    public boolean isMultipleChoiceQuestion()
    {
        return false;
    }

}

