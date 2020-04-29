package com.whirlpool.androidfundamentalsapril;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivityWeek3 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private final static String TAG = MainActivityWeek3.class.getSimpleName();
    private static final String BASE_URL = "https://www.uplips.com/";
    // private ArrayList<String> androidVersions;
    private String[] androidVersions;
    private ArrayAdapter<String> adapter;

    private String emailField;
    private String passwordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_week3);

        WebView webView = findViewById(R.id.webView);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.loadUrl(BASE_URL);

        // androidVersions = getDataSource();
        androidVersions = getResources().getStringArray(R.array.data);

        Spinner androidVersionsSpinner = findViewById(R.id.android_versions_spinner);
        adapter = getAdapter();

        androidVersionsSpinner.setAdapter(adapter);

        androidVersionsSpinner.setOnItemSelectedListener(this);


        final EditText email = findViewById(R.id.email);
        final EditText pass = findViewById(R.id.pass);
        Button login = findViewById(R.id.login_button);


        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //emailField = charSequence.toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        pass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // passwordField = charSequence.toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                emailField = email.getText().toString();
                passwordField = pass.getText().toString();

                Log.d(TAG, "Email: " + emailField + " PASS: " + passwordField);

                if (emailField.isEmpty()) {
                    email.setError("You need to add a correct email.");
                } else {
                    email.setError(null);
                }

                if (passwordField.isEmpty()) {
                    pass.setError("You need to add a correct pass.");
                } else {
                    pass.setError(null);
                }
            }
        });
    }


    private ArrayList<String> getDataSource() {
        ArrayList<String> androidVersions = new ArrayList<>();
        androidVersions.add("Cupcake");
        androidVersions.add("Lollipop");
        androidVersions.add("Jelly Bean");
        androidVersions.add("Oreo");

        return androidVersions;
    }

    private ArrayAdapter<String> getAdapter() {
        return new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, androidVersions);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Log.d(TAG, "position: " + i);

        Toast.makeText(this, "POSITION SELECTED: " + i, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
