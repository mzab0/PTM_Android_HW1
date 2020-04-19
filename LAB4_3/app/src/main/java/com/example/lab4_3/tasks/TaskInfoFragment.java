package com.example.lab4_3.tasks;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab4_3.MainActivity;
import com.example.lab4_3.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TaskInfoFragment extends Fragment {

    public TaskInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            TaskListContent.Task receivedTask = intent.getParcelableExtra(MainActivity.taskExtra);
            if (receivedTask != null) {
                displayTask((receivedTask));
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task_info, container, false);
    }

    public void displayTask(TaskListContent.Task task) {
        FragmentActivity activity = getActivity();
        TextView taskInfoTitle = activity.findViewById(R.id.taskInfoTitle);
        TextView taskInfoDescription = activity.findViewById(R.id.taskInfoDescription);
        TextView birth=activity.findViewById(R.id.birth);

        ImageView taskInfoImage = activity.findViewById(R.id.taskInfoImage);

        taskInfoTitle.setText(task.name+" "+task.surname);
        taskInfoDescription.setText(task.number);
        birth.setText(task.birthday);
        final String picPath=task.picPath;

            Drawable taskDrawable;
                switch (task.picPath) {
                    case "0":
                        taskDrawable = activity.getResources().getDrawable(R.drawable.avatar_1);
                        break;
                    case "1":
                        taskDrawable = activity.getResources().getDrawable(R.drawable.avatar_2);
                        break;
                    case "2":
                        taskDrawable = activity.getResources().getDrawable(R.drawable.avatar_3);
                        break;
                    case "3":
                        taskDrawable = activity.getResources().getDrawable(R.drawable.avatar_4);
                        break;
                    case "4":
                        taskDrawable = activity.getResources().getDrawable(R.drawable.avatar_5);
                        break;
                    case "5":
                        taskDrawable = activity.getResources().getDrawable(R.drawable.avatar_6);
                        break;
                    case "6":
                        taskDrawable = activity.getResources().getDrawable(R.drawable.avatar_7);
                        break;
                    case "7":
                        taskDrawable = activity.getResources().getDrawable(R.drawable.avatar_9);
                        break;
                    default:
                        taskDrawable = activity.getResources().getDrawable(R.drawable.avatar_1);
                }
                taskInfoImage.setImageDrawable(taskDrawable);
            }
        }


