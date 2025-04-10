package com.example.taskmanager;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="tasks")
public class RoomTable {
    @PrimaryKey
    @NonNull
    private String id;
    private String title;
    private String description;
    private String due_date;

    public RoomTable(String title, String description, String due_date) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.due_date = due_date;
    }

    public String getId() {
        return id;
    }

    public void setId(String title) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDue_date() {
        return due_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }
}