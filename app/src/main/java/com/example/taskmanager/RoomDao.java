package com.example.taskmanager;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


@Dao
public interface RoomDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(RoomTable task);

    @Update
    void update(RoomTable task);

    @Query("SELECT * FROM tasks ORDER By due_date")
    LiveData<List<RoomTable>> getRoomTable();

    @Query("DELETE from tasks")
    void deleteAll();
}