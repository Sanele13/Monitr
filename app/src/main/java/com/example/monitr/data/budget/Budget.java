package com.example.monitr.data.budget;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Budget {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
