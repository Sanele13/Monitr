package com.example.monitr.ui.dashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.monitr.R;
import com.example.monitr.data.budget.Budget;

import java.util.List;

public class BudgetAdapter extends RecyclerView.Adapter<BudgetAdapter.BudgetViewHolder> {

    private List<Budget> items;

    public BudgetAdapter(List<Budget> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public BudgetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.budget_card, parent, false);
        return new BudgetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BudgetViewHolder holder, int position) {
        Budget item = items.get(position);
        holder.tvTitle.setText(item.getTitle());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class BudgetViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;

        public BudgetViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.title);
        }
    }
}