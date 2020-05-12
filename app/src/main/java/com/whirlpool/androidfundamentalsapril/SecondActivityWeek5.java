package com.whirlpool.androidfundamentalsapril;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by roxanan on 12,May,2020
 */
public class SecondActivityWeek5 extends AppCompatActivity {
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_week5);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null){
            message = bundle.getString(MainActivityWeek5.MESSAGE);
        }

        TextView firstActivityMessage = findViewById(R.id.first_activity_message);
        Button finishSecondActivity = findViewById(R.id.finish_second_activity);

        firstActivityMessage.setText(message);

        finishSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent finishSecond = new Intent();
                setResult(Activity.RESULT_CANCELED, finishSecond);
                finish();
            }
        });
    }
}
