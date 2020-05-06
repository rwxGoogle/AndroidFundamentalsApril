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
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecycleViewHolder> {
    private final static String TAG = RecyclerViewAdapter.class.getSimpleName();
    private final List<String> data;

    RecyclerViewAdapter(List<String> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public RecycleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View recyclerRow = layoutInflater.inflate(R.layout.item_car, viewGroup, false);
        return new RecycleViewHolder(recyclerRow);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewHolder recycleViewHolder, final int position) {
        String name = data.get(position);
        recycleViewHolder.carNameTextView.setText(name);

        recycleViewHolder.carNameTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick(), position= " + position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class RecycleViewHolder extends RecyclerView.ViewHolder {

        final TextView carNameTextView;

        RecycleViewHolder(@NonNull View itemView) {
            super(itemView);
            this.carNameTextView = itemView.findViewById(R.id.car_name);
        }
    }
}
