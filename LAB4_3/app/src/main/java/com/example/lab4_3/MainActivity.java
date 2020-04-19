package com.example.lab4_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.lab4_3.DeleteDialog.OnDeleteDialogInteractionListener;
import com.example.lab4_3.tasks.TaskInfoFragment;
import com.example.lab4_3.tasks.TaskListContent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements TaskFragment.OnListFragmentInteractionListener, DeleteDialog.OnDeleteDialogInteractionListener,
DeletingItem.OnDeletingItemDialogInteractionListener{

    public static final String taskExtra = "taskExtra";
    private int currentItemPosition=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void onListFragmentClickInteraction(TaskListContent.Task task, int position) {
        Toast.makeText(this,getString(R.string.item_selected_msg),Toast.LENGTH_SHORT).show();
        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE){
            displayTaskInFragment(task);
        }
        else{
            startSecondAcitivity(task,position);
        }

    }

    @Override
    public void onListFragmentLongClickInteraction(int position) {
        showDeleteDialog();
    }

    @Override
    public void onDeleteClickInteraction(int position) {
        deleteItem();
        currentItemPosition = position ;
    }


    private void startSecondAcitivity(TaskListContent.Task task, int position)
    {
        Intent intent=new Intent(this, TaskInfoActivity.class);
        intent.putExtra(taskExtra,task);
        startActivity(intent);
    }



    public void adding(View view) {
        Intent intent=new Intent(this,AddingActivity.class);
        startActivity(intent);
    }

    private void displayTaskInFragment(TaskListContent.Task task)
    {
        TaskInfoFragment taskInfoFragment=((TaskInfoFragment)getSupportFragmentManager().findFragmentById(R.id.displayFragment));
        if(taskInfoFragment!=null)
        {
            taskInfoFragment.displayTask(task);
        }
    }

    private void showDeleteDialog()
    {

        DeleteDialog.newInstance().show(getSupportFragmentManager(),getString(R.string.info));
    }



    public void deleteItem() {
        DeletingItem.newInstance().show(getSupportFragmentManager(),"Delete");
    }

    public void deleteItem(View view) {
        DeletingItem.newInstance().show(getSupportFragmentManager(),"Delete");
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {

        if(currentItemPosition != -1 && currentItemPosition < TaskListContent.ITEMS.size()){
            TaskListContent.removeItem(currentItemPosition);

        }
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
