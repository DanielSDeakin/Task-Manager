package com.example.taskmanager;

import android.os.Bundle;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;


@Dao
public interface DAO {
    @Insert
    void insert(RoomTable task);

    @Query("SELECT * FROM tasks")
    List<RoomTable> getAllTasks();
}