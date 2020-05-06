package com.whirlpool.androidfundamentalsapril;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Created by roxanan on 05,May,2020
 */
public class NumbersRecyclerViewAdapter extends RecyclerView.Adapter<NumbersRecyclerViewAdapter.NumbersViewHolder> {
    private final static String TAG = NumbersRecyclerViewAdapter.class.getSimpleName();
    private List<Integer> numbersList;

    NumbersRecyclerViewAdapter(List<Integer> numbers) {
        this.numbersList = numbers;
    }

    @NonNull
    @Override
    public NumbersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View recyclerRow = layoutInflater.inflate(R.layout.item_number, parent, false);
        return new NumbersViewHolder(recyclerRow);
    }

    @Override
    public void onBindViewHolder(@NonNull NumbersViewHolder holder, final int position) {
        final String number = "Number: " + numbersList.get(position);
        holder.numberText.setText(number);

        holder.numberText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick(), position: " + position + " " + number);
            }
        });
    }

    @Override
    public int getItemCount() {
        return numbersList.size();
    }

    static class NumbersViewHolder extends RecyclerView.ViewHolder {
        private TextView numberText;

        NumbersViewHolder(View item) {
            super(item);
            numberText = item.findViewById(R.id.number);
        }
    }
}
