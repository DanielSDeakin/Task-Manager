package com.example.taskmanager;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.taskmanager.RoomTable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {RoomTable.class}, version = 1, exportSchema = false)
public abstract class TaskDatabase extends RoomDatabase {
    public abstract RoomDao roomDao();

    private static volatile TaskDatabase taskDatabase;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static TaskDatabase getDatabase(final Context context) {
        if (taskDatabase == null) {
            synchronized (TaskDatabase.class) {
                if (taskDatabase == null) {
                    taskDatabase = Room.databaseBuilder(context.getApplicationContext(), TaskDatabase.class, "task_database").build();
                }
            }
        }
        return taskDatabase;
    }
}