package com.example.taskmanager;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.app.Application;
import androidx.lifecycle.LiveData;
import java.util.List;


public class TaskRepo {
    TaskDatabase taskDatabase;
    RoomDao roomDao;
    private LiveData<List<RoomTable>> listRoomTables;

    public TaskRepo(Application application) {
        taskDatabase = TaskDatabase.getDatabase(application);
        roomDao = taskDatabase.roomDao();
        listRoomTables = roomDao.getRoomTable();
    }

        public void insertRoomTable(RoomTable task) {
        TaskDatabase.databaseWriteExecutor.execute(() -> roomDao.insert(task));
        }

        public LiveData<List<RoomTable>> getAllRoomTables() {
            return listRoomTables;
        }

}