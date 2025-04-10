package com.example.taskmanager;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class RoomViewModel extends AndroidViewModel {
    private TaskRepo taskRepo;
    private final LiveData<List<RoomTable>> listLiveData;

    public RoomViewModel(Application application) {
        super(application);
        taskRepo = new TaskRepo(application);
        listLiveData = taskRepo.getAllRoomTables();
    }

    public LiveData<List<RoomTable>> getAllRoomTablesFromVm() {
        return listLiveData;
    }

    public void insertRoomTable(RoomTable task) {
        taskRepo.insertRoomTable(task);
    }
}