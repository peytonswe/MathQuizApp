package com.example.ksusha.mathquizapp;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnSubmit;
    EditText editTextQuestion1;

    RadioButton correctOptionQuestion2;
    RadioButton correctOptionQuestion3;

    CheckBox firstCorrectOptionQuestion4;
    CheckBox secondCorrectOptionQuestion4;

    EditText editTextQuestion5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSubmit = (Button) findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (checkAllAnswer()) {
            Toast.makeText(this, "Hooray! \nYour answers are all correct. Congrats!", Toast.LENGTH_LONG).show();
        }  else {
            Toast.makeText(this, "Try again! \nSomething wrong. Check your answer, " +
                    "all questions must be filled out.", Toast.LENGTH_LONG).show();
        }

    }

    public boolean checkAllAnswer() {
        Boolean questionsAnswered = true;

        if (!checkFirstQuestion()) {
            questionsAnswered = false;
        }

        if (!checkSecondQuestion()) {
            questionsAnswered = false;
        }

        if (!checkThirdQuestion()) {
            questionsAnswered = false;
        }

        if (!checkFourthQuestion()) {
            questionsAnswered = false;
        }

        if (!checkFifthQuestion()) {
            questionsAnswered = false;
        }

        return questionsAnswered;

    }


    @TargetApi(Build.VERSION_CODES.KITKAT)
    public boolean checkFirstQuestion() {
        editTextQuestion1 = (EditText) findViewById(R.id.edit_text_question_1);
        String answerQuestion1 = editTextQuestion1.getText().toString();
        return Objects.equals(answerQuestion1, "Geometry");
    }

    public boolean checkSecondQuestion() {
        correctOptionQuestion2 = (RadioButton) findViewById(R.id.option2_3);
        return correctOptionQuestion2 != null && correctOptionQuestion2.isChecked();
    }

    public boolean checkThirdQuestion() {
        correctOptionQuestion3 = (RadioButton) findViewById(R.id.option3_1);
        return correctOptionQuestion3 != null && correctOptionQuestion3.isChecked();
    }

    public boolean checkFourthQuestion() {
        firstCorrectOptionQuestion4 = (CheckBox) findViewById(R.id.option4_1);
        secondCorrectOptionQuestion4 = (CheckBox) findViewById(R.id.option4_4);

        return firstCorrectOptionQuestion4 != null && firstCorrectOptionQuestion4.isChecked()
                && secondCorrectOptionQuestion4 != null && secondCorrectOptionQuestion4.isChecked();
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public boolean checkFifthQuestion() {
        editTextQuestion5 = (EditText) findViewById(R.id.edit_text_question_5);
        String answerQuestion5 = editTextQuestion5.getText().toString();
        return Objects.equals(answerQuestion5, "Euclid");

    }

}
