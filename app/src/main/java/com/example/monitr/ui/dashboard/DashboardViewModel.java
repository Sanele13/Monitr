package com.example.monitr.ui.dashboard;

import static com.example.monitr.MainActivity.db;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.monitr.data.budget.Budget;
import com.example.monitr.data.budget.BudgetDao;
import com.example.monitr.data.budget.BudgetRepository;

import java.util.List;

public class DashboardViewModel extends AndroidViewModel {

    private final BudgetRepository repository;
    private final LiveData<List<Budget>> budgets;

    public DashboardViewModel(@NonNull Application application) {
        super(application);
        repository = new BudgetRepository(application);
        budgets = repository.getAllBudgets();
    }

    public LiveData<List<Budget>> getBudgets() {
        return budgets;
    }

    public void addBudget(Budget budget) {

        repository.insert(budget);
    }
}
