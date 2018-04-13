package com.example.myfirstapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String[] results = intent.getStringArrayExtra(MainActivity.EXTRA_MESSAGE);
        //String computer = intent.getStringExtra(MainActivity.COMP_MESSAGE);
        //String results = intent.getStringExtra(MainActivity.RESULTS_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(results[0]);

        TextView textView2 = findViewById(R.id.textView2);
        textView2.setText(results[1]);

        TextView textView3 = findViewById(R.id.textView3);
        textView3.setText(results[2]);
    }
}
