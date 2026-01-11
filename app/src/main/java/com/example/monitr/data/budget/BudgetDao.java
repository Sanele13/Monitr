package com.example.monitr.data.budget;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BudgetDao {
    @Query("SELECT * FROM budget")
    LiveData<List<Budget>> getAll();

    @Insert
    void insert(Budget budget);
}
