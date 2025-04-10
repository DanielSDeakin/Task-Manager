package com.example.taskmanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CreateTask extends AppCompatActivity {
    private EditText EditTaskText;
    private EditText EditDescText;
    private EditText EditDueText;
    public Button UploadButton;
    private TaskDatabase database;

    public void upload_task(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_task);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        UploadButton = findViewById(R.id.UploadButton);
        UploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditTaskText = findViewById(R.id.EditTaskText);
                EditDescText = findViewById(R.id.EditDescText);
                EditDueText = findViewById(R.id.EditDueText);
                String title = EditTaskText.getText().toString();
                String desc = EditDescText.getText().toString();
                String date = EditDueText.getText().toString();

                RoomTable task = new RoomTable(title, desc, date);
                //database.taskDao().insert(task);
            }

        });
    }
}