package com.whirlpool.androidfundamentalsapril;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class MainActivityWeek4Ex1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_week4ex1);

        DataSource dataSource = new DataSource();
        List<Integer> numbers = dataSource.getNumbers();

        RecyclerView recyclerView = findViewById(R.id.numbers_list);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        recyclerView.setLayoutManager(linearLayoutManager);

        NumbersRecyclerViewAdapter numbersRecyclerViewAdapter = new NumbersRecyclerViewAdapter(numbers);

        recyclerView.setAdapter(numbersRecyclerViewAdapter);
    }

}
