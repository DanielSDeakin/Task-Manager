package com.example.taskmanager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RoomViewModel roomViewModel;
    private RoomTableListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Set up window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize RecyclerView and ViewModel
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        roomViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(RoomViewModel.class);

        // Observe LiveData from ViewModel and update RecyclerView when data changes
        roomViewModel.getAllRoomTablesFromVm().observe(this, tasks -> {
            if (tasks != null && !tasks.isEmpty()) {
                Log.d("MainActivity", "Task List Size: " + tasks.size());
                // Initialize the adapter if tasks are present
                if (adapter == null) {
                    adapter = new RoomTableListAdapter((ArrayList<RoomTable>) tasks);
                    recyclerView.setAdapter(adapter);
                } else {
                    // If adapter already exists, just notify data change
                    adapter.notifyDataSetChanged();
                }
            } else {
                Log.d("MainActivity", "No tasks found");
            }
        });
    }

    // Button click to navigate to CreateTask activity
    public void add_task(View view) {
        Intent intent = new Intent(this, CreateTask.class);
        startActivity(intent);
    }

    // This method is not needed anymore as tasks are already observed in onCreate
    public void show_task(View view) {
        // The tasks are already being shown by observing the LiveData in onCreate
    }
}
