package com.whirlpool.androidfundamentalsapril;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CCActivityWeek5 extends AppCompatActivity {
    public static final String TEXT_ONE = "Text One";
    public static final String TEXT_TWO = "Text Two";
    public static final String TEXT_THREE = "Text Three";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_c_week5);

        Button textOneButton = findViewById(R.id.text_one);
        Button textTwoButton = findViewById(R.id.text_two);
        Button textThreeButton = findViewById(R.id.text_three);


        textOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CCActivityWeek5.this, CCSecondActivityWeek5.class);
                intent.putExtra(TEXT_ONE, "Luni");
                startActivity(intent);
            }
        });

        textTwoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CCActivityWeek5.this, CCSecondActivityWeek5.class);
                intent.putExtra(TEXT_TWO, "Marti");
                startActivity(intent);
            }
        });

        textThreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CCActivityWeek5.this, CCSecondActivityWeek5.class);
                intent.putExtra(TEXT_THREE, "Miercuri");
                startActivity(intent);
            }
        });
    }
}
