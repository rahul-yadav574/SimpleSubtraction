package com.example.hemantbansal.subtract;

import android.support.annotation.ArrayRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Random;

public class PractiseActivity extends AppCompatActivity {


    private TextView questionText;
    private Button checkAnswer;
    private EditText answerInput;
    private int whichQuestion,max=13,min=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practise);



        final String [] questions = getResources().getStringArray(R.array.questions_array);
        final int [] answers = new int[]{5,4,7,4,1,1,3,5,2,1,7,3,3,2};

        final Random rand = new Random();
        whichQuestion = rand.nextInt((max - min) + 1) + min;


        setTitle("Practise Here");

        questionText = (TextView) findViewById(R.id.questionTxt);
        checkAnswer = (Button) findViewById(R.id.checkAnswer);
        answerInput = (EditText) findViewById(R.id.answerInput);

        questionText.setText(questions[whichQuestion]);

        checkAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (answerInput.getText().toString().length()>0){
                    if (Integer.parseInt(answerInput.getText().toString())== answers[whichQuestion]){
                        Toast.makeText(PractiseActivity.this,"Correct Answer",Toast.LENGTH_SHORT).show();
                        whichQuestion = rand.nextInt((max - min) + 1) + min;
                        questionText.setText(questions[whichQuestion]);
                        answerInput.setText("");
                    }else {
                        answerInput.setText("");
                        Toast.makeText(PractiseActivity.this,"Wrong Answer...Try Again",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(PractiseActivity.this, "Enter A Valid Answer", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
