package com.example.mp5_part2_andrescabrera;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView;
import android.content.Intent;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private static final String[] topics = {"Sports","Music","Life"};
    private static final int REQUIRED_CODE = 2468;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent intent = new Intent(this, quiz.class);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, topics);

        ListView topics_list = (ListView) findViewById(R.id.listView);
        topics_list.setAdapter(adapter);

        topics_list.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> list, View row, int index, long rowID) {

                        String topic = list.getItemAtPosition(index).toString();

                        intent.putExtra("topic", topic);
                        startActivityForResult(intent,REQUIRED_CODE);
                    }
                }
        );
    }

    public void restButton(View view) {
        score = 0;
        TextView see_score = (TextView) findViewById(R.id.textView2);
        String string_score = "Score: " + Integer.toString(score);
        see_score.setText(string_score);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == REQUIRED_CODE) {
            int point = intent.getIntExtra("point", 0);
            score = score + point;
            TextView see_score = findViewById(R.id.textView2);
            String string_score = "Score: " + Integer.toString(score);
            see_score.setText(string_score);
        }
    }
}