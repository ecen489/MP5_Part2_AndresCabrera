package com.example.mp5_part2_andrescabrera;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Scanner;

public class quiz extends AppCompatActivity {

    private static final String[] topics = {"Sports","Music","Life"};
    private static final String[] answers = new String[4];
    private static final String[] questions = new String[4];

    String topic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_layout);

        Scanner scan = new Scanner(getResources().openRawResource(R.raw.answers));

        int i = 0;
        while(scan.hasNextLine()){
            String line=scan.nextLine();
            answers[i]=line;
            i++;
        }

        scan = new Scanner(getResources().openRawResource(R.raw.questions));

        i = 0;
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            questions[i] = line;
            i++;
        }
        scan.close();

        Intent intent = getIntent();
        topic = intent.getStringExtra("topic");

        if(topic.equals(topics[0]))
        {
            TextView textView = (TextView) findViewById(R.id.textView4);
            textView.setText(questions[0]);

        }
        else if(topic.equals(topics[1]))
        {
            TextView textView = (TextView) findViewById(R.id.textView4);
            textView.setText(questions[1]);

        }
        else
        {
            TextView textView = (TextView) findViewById(R.id.textView4);
            textView.setText(questions[2]);

        }
    }

    public void subButton(View view) {
        EditText user_answer = (EditText) findViewById(R.id.editText);

        String answer = user_answer.getText().toString().toLowerCase();

        Intent backIntent = new Intent();

        if(topic.equals(topics[0]))
        {
            if(answer.equals(answers[0]))
            {
                backIntent.putExtra("point", 1);
                Toast.makeText(quiz.this, "Right Answer! You've earned a point.",Toast.LENGTH_SHORT).show();
                setResult(RESULT_OK, backIntent);
                finish();

            }
            else
            {
                backIntent.putExtra("point", 0);
                Toast.makeText(quiz.this, "Wrong Answer! Try again.",Toast.LENGTH_SHORT).show();
                setResult(RESULT_OK, backIntent);
                finish();
            }

        }
        else if(topic.equals(topics[1]))
        {
            if(answer.equals(answers[1]))
            {
                backIntent.putExtra("point", 1);
                Toast.makeText(quiz.this, "Right Answer! You've earned a point.",Toast.LENGTH_SHORT).show();
                setResult(RESULT_OK, backIntent);
                finish();

            }
            else
            {
                backIntent.putExtra("point", 0);
                Toast.makeText(quiz.this, "Wrong Answer! Try again.",Toast.LENGTH_SHORT).show();
                setResult(RESULT_OK, backIntent);
                finish();
            }

        }
        else
        {
            if(answer.equals(answers[2]))
            {
                backIntent.putExtra("point", 1);
                Toast.makeText(quiz.this, "Right Answer! You've earned a point.",Toast.LENGTH_SHORT).show();
                setResult(RESULT_OK, backIntent);
                finish();

            }
            else
            {
                backIntent.putExtra("point", 0);

                Toast.makeText(quiz.this, "Wrong Answer! Try again.",Toast.LENGTH_SHORT).show();
                setResult(RESULT_OK, backIntent);
                finish();
            }
        }
    }
}