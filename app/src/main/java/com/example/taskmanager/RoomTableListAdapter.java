package com.example.taskmanager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomTableListAdapter extends RecyclerView.Adapter<RoomTableListAdapter.RoomTableViewHolder> {
    ArrayList<RoomTable> taskArrayList;

    public RoomTableListAdapter(ArrayList<RoomTable> tasks) {
        this.taskArrayList = tasks;
    }

    @NonNull
    @Override
    public RoomTableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.task_item, parent, false);
        return new RoomTableViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomTableViewHolder holder, int position) {
        RoomTable task = taskArrayList.get(position);
        holder.textTitle.setText(taskArrayList.get(position).getTitle());
        holder.textDesc.setText((taskArrayList.get(position).getDescription()));
        holder.textDate.setText(taskArrayList.get(position).getDue_date());
    }

    public void updateData(List<RoomTable> newTaskList) {
        taskArrayList.clear();
        taskArrayList.addAll(newTaskList);
    }

    @Override
    public int getItemCount() {
        return taskArrayList.size();
    }

    static class RoomTableViewHolder extends RecyclerView.ViewHolder {
        TextView textTitle;
        TextView textDesc;
        TextView textDate;

        public RoomTableViewHolder(@NonNull View itemView) {
            super(itemView);

            findViews();
        }

        private void findViews() {
            textTitle = itemView.findViewById(R.id.EditTaskText);
            textDesc = itemView.findViewById(R.id.EditDescText);
            textDate = itemView.findViewById(R.id.EditDueText);
        }
    }
}
