package com.whirlpool.androidfundamentalsapril;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by roxanan on 12,May,2020
 */
public class MainActivityWeek5 extends AppCompatActivity {
    private static final String TAG = MainActivityWeek5.class.getSimpleName();
    private static final String NAME_KEY = "name_key";
    private static final String NUMBER_KEY = "number_key";
    private static final int SECOND_REQUEST_CODE = 2;
    private static final int THIRD_REQUEST_CODE = 3;
    public static final String MESSAGE = "message";
    EditText inputName;
    EditText inputNumber;
    TextView dummyData;
    String name;
    String number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_week5);

        // Log.d(TAG, "onCreate()");

        Button startSecondActivity = findViewById(R.id.start_second_activity);
        Button startThirdActivity = findViewById(R.id.start_third_activity);
        Button callButton = findViewById(R.id.call_button); // open dialer => using IMPLICIT INTENT
        final Button openBrowser = findViewById(R.id.open_browser); // open browser => using IMPLICIT INTENT

        inputName = findViewById(R.id.name_input);
        inputNumber = findViewById(R.id.number_input);

        dummyData = findViewById(R.id.dummy_data);

        if (savedInstanceState != null) {
            String storedName = savedInstanceState.getString(NAME_KEY);
            String storedNumber = savedInstanceState.getString(NUMBER_KEY);

            Log.d(TAG, "Stored Name= " + storedName);
            Log.d(TAG, "Stored Number= " + storedNumber);
        }

        inputName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                name = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        inputNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                number = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        startSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondIntent = new Intent(MainActivityWeek5.this, SecondActivityWeek5.class);
//                secondIntent.putExtra(MESSAGE, name);
//                startActivity(secondIntent);

                startActivityForResult(secondIntent, SECOND_REQUEST_CODE);
            }
        });

        startThirdActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent thirdIntent = new Intent(MainActivityWeek5.this, ThirdActivityWeek5.class);
                startActivityForResult(thirdIntent, THIRD_REQUEST_CODE);
            }
        });

        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("09980809890"));
                startActivity(callIntent);
            }
        });

        openBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openBrowserIntent = new Intent(Intent.ACTION_VIEW);
                openBrowserIntent.setData(Uri.parse("https://www.google.com"));
                startActivity(openBrowserIntent);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d(TAG, "onSaveInstanceState()");
        outState.putString(NAME_KEY, name);
        outState.putString(NUMBER_KEY, number);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SECOND_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                Log.d(TAG, "result code= " + resultCode + " requestCode= " + requestCode);
            } else if (resultCode == Activity.RESULT_CANCELED) {
                Log.d(TAG, "result code= " + resultCode + " requestCode= " + requestCode);
            }
        } else if (requestCode == THIRD_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                Log.d(TAG, "result code= " + resultCode + " requestCode= " + requestCode);
                if (data != null) {
                    dummyData.setText(data.getStringExtra(ThirdActivityWeek5.EXTRA_DATA));
                }
            } else if (resultCode == Activity.RESULT_CANCELED) {
                Log.d(TAG, "result code= " + resultCode + " requestCode= " + requestCode);
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Log.d(TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Log.d(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Log.d(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();

        // Log.d(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // Log.d(TAG, "onDestroy()");
    }
}
