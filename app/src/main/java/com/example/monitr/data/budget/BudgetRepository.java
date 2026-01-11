package com.example.monitr.data.budget;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.monitr.data.AppDatabase;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class BudgetRepository {

    private final BudgetDao budgetDao;
    private final LiveData<List<Budget>> allBudgets;
    private final Executor executor = Executors.newSingleThreadExecutor();

    public BudgetRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        budgetDao = db.budgetDao();
        allBudgets = budgetDao.getAll();
    }

    public LiveData<List<Budget>> getAllBudgets() {
        return allBudgets;
    }

    public void insert(Budget budget) {
        executor.execute(() -> budgetDao.insert(budget));
    }
}
