package com.whirlpool.androidfundamentalsapril;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class CCSecondActivityWeek5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_c_secod_week5);
        TextView messageReceived = findViewById(R.id.message_received);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            String textOne = bundle.getString(CCActivityWeek5.TEXT_ONE);
            String textTwo = bundle.getString(CCActivityWeek5.TEXT_TWO);
            String textThree = bundle.getString(CCActivityWeek5.TEXT_THREE);
            if (textOne != null) {
                messageReceived.setText(textOne);
            } else if (textTwo != null) {
                messageReceived.setText(textTwo);
            } else if (textThree != null) {
                messageReceived.setText(textThree);
            }
        }

    }
}
