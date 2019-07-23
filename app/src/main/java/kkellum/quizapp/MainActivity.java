package kkellum.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTextView;
    private EditText mEditText;

    private LinearLayout mTrueFalseContainer;
    private LinearLayout mFillTheBlankContainer;

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private Button mPrevious;
    private Button mCheckButton;
    private Button mCheatButton;

    private Question[] mQuestions;
    private int mIndex;
    private int mscore;
    private boolean mCheated = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.False_button);
        mNextButton = (Button) findViewById(R.id.next_button);
        mPrevious = (Button) findViewById(R.id.previous_button);
        mCheckButton =( Button) findViewById(R.id.check_button);
        mCheatButton = (Button) findViewById(R.id.cheat_button);

        mTrueFalseContainer = (LinearLayout) findViewById(R.id.true_false_container);

        mFillTheBlankContainer = (LinearLayout) findViewById(R.id.fill_the_blank_container);

        mEditText = (EditText) findViewById(R.id.edit_text);


        mTrueButton.setOnClickListener(this);
        mFalseButton.setOnClickListener(this);
        mNextButton.setOnClickListener(this);
        mPrevious.setOnClickListener(this);
        mCheckButton.setOnClickListener(this);
        mCheatButton.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.text_view);

        // Initialize an array of questions.
        mQuestions = new Question[5];
        mIndex = 0;

        // Initialize each slot in the array.
        mQuestions[0] = new TrueFalseQuestion(R.string.question_1,0, true);
        mQuestions[1] = new TrueFalseQuestion(R.string.question_2, 0, false);
        mQuestions[2] = new TrueFalseQuestion(R.string.question_3, 0, true);
        mQuestions[3] = new TrueFalseQuestion(R.string.question_4, 0, false);
        mQuestions[4] = new TrueFalseQuestion(R.string.question_5, 0, false);

        String[] q5Answers = getResources().getStringArray(R.array.question_6_answers);
        mQuestions[5] = new FillTheBlankQuestion(R.string.question_6, R.string.quesiton_6_hint, q5Answers);

        //setup the first question.
      setupQuestion();

    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.true_button) {
            checkAnswer(true);
        } else if (view.getId() == R.id.False_button) {
            checkAnswer(false);
        }
        else if (view.getId() == R.id.check_button)
        {
            checkAnswer(mEditText.getText().toString());
        }
        else if (view.getId() == R.id.next_button) {

            // change to the next question...

            //Increment the index by one.
            mIndex++;

            //do if statement here:
            // if the mIdex is greater than or equal to mQuestions.length
            //  -set mIndex to 0
            // - end the quiz

            //change text in view.
            mTextView.setText(mQuestions[mIndex].getTextResId());
        }
        else if(view.getId() == R.id.previous_button) {

            //change to the previous question...

            //reduction the index by one
            mIndex--;

            //do if statement here:
            // -set mIndex to 0
            //-after every question

            //change in text in view.
            setupQuestion();


        }
        else if (view.getId() == R.id.cheat_button)
        {
           // TODO: Launch CheatActivity
            Intent cheatIntent = CheatActivity.newIntent(this);
            startActivity(cheatIntent);
        }
    }

    public void setupQuestion()
    {
        mTextView.setText(mQuestions[mIndex].getTextResId());

        if (mQuestions[mIndex].isTrueFalseQuestion())
        {
             mTrueFalseContainer.setVisibility(View.VISIBLE);
             mFillTheBlankContainer .setVisibility(View.GONE);
        }
        else if (mQuestions[mIndex].isFillTheBlankQuestion())
        {
            mTrueFalseContainer.setVisibility(View.GONE);
            mFillTheBlankContainer .setVisibility(View.VISIBLE);
        }
        else if (mQuestions[mIndex].isMultipleChoiceQuestion())
        {
            //TODO: hide and show relevance containers
        }
    }

    public boolean checkAnswer(boolean userInput)
    {
        if(mQuestions[mIndex].checkAnswer(userInput))
        {
            Toast myToast = Toast.makeText(this, "you are correct", Toast.LENGTH_SHORT);
            myToast.show();
            return true;
        }
        else
        {
            Toast myToast = Toast.makeText(this, "you are incorrect", Toast.LENGTH_SHORT);
            myToast.show();
            return false;
        }
    }
    public boolean checkAnswer(String userInput)
    {
        if(mQuestions[mIndex].checkAnswer(userInput))
        {
            Toast myToast = Toast.makeText(this, "you are correct", Toast.LENGTH_SHORT);
            myToast.show();
            return true;
        }
        else
        {
            Toast myToast = Toast.makeText(this, "you are incorrect", Toast.LENGTH_SHORT);
            myToast.show();
            return false;
        }
    }
}





