package com.whirlpool.androidfundamentalsapril.week6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

import com.whirlpool.androidfundamentalsapril.R;

public class Week6Activity extends AppCompatActivity implements Week6Interface {
    private static final String TAG = Week6Activity.class.getSimpleName();
    public static final String KEY = "key";
    private String color = "#00000";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week6);

        Log.d(TAG, "onCreate");

        Bundle bundle = new Bundle();
        bundle.putString(KEY, "Hello guys.");

        Week6Fragment week6Fragment = new Week6Fragment();
        week6Fragment.setArguments(bundle);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, week6Fragment, Week6Fragment.class.getSimpleName());
        fragmentTransaction.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        Week6Fragment week6Fragment = (Week6Fragment) getSupportFragmentManager().findFragmentByTag(Week6Fragment.class.getSimpleName());
        week6Fragment.setColors(color);
    }

    @Override
    public void setColor(String color) {
        Log.d(TAG, "setColor() ," + color);
    }
}
