package com.example.monitr.ui.dashboard;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.monitr.R;
import com.example.monitr.data.budget.Budget;
import com.example.monitr.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        dashboardViewModel.getBudgets().observe(getViewLifecycleOwner(), budgets -> {
            RecyclerView recyclerView = binding.recyclerView;
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

            BudgetAdapter adapter = new BudgetAdapter(budgets);
            recyclerView.setAdapter(adapter);

            Log.d("Budgets", "Count: " + budgets.size());
        });

        binding.addBudgetButton.setOnClickListener(v -> {
            EditText input = new EditText(requireContext());
            input.setHint("Budget title");

            new AlertDialog.Builder(requireContext())
                    .setTitle("New Budget")
                    .setView(input)
                    .setPositiveButton("Save", (d, w) -> {
                        String title = input.getText().toString().trim();
                        Budget budget = new Budget();
                        budget.setTitle(title);
                        if (!title.isEmpty()) {
                            dashboardViewModel.addBudget(budget);
                        }
                    })
                    .setNegativeButton("Cancel", null)
                    .show();
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}