package com.example.lab4_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.lab4_3.tasks.TaskListContent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddingActivity extends AppCompatActivity implements TaskFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding);
    }

    public void addingItem(View view) {
        EditText taskTitleEditTxt= findViewById(R.id.Name);
        EditText surnameEditTxt=findViewById(R.id.Surname);
        EditText taskDescriptionEditTxt=findViewById(R.id.PhoneNumber);
        EditText birthdayEditTxt=findViewById(R.id.Birthday);

        String taskTitle=taskTitleEditTxt.getText().toString();
        String taskDescription=taskDescriptionEditTxt.getText().toString();
        String surname=surnameEditTxt.getText().toString();
        String birthday=birthdayEditTxt.getText().toString();
        String selectedImage="4";


        if(taskTitle.isEmpty())
        {
            taskTitle="Default";
        }
        if(surname.isEmpty())
        {
            surname="Default";
        }
        if(!birthdayTest(birthday))
        {
            birthdayEditTxt.setError("Required format of data: (dd/MM/yy)");
        }
        if(!phoneTest(taskDescription))
        {
            taskDescriptionEditTxt.setError("Check provided number phone!");
        }


        if(phoneTest(taskDescription)&& birthdayTest(birthday)) {
            TaskListContent.addItem(new TaskListContent.Task("Task." + TaskListContent.ITEMS.size() + 1,
                    taskTitle, surname, taskDescription, birthday, selectedImage));
            Intent intent=new Intent(this, MainActivity.class);
            startActivity(intent);
        }


        //((TaskFragment) getSupportFragmentManager().findFragmentById(R.id.taskFragment)).notifyDataChange();

        taskTitleEditTxt.setText("");
        birthdayEditTxt.setText("");
        surnameEditTxt.setText("");
        taskDescriptionEditTxt.setText("");


    }

    @Override
    public void onListFragmentClickInteraction(TaskListContent.Task task, int position) {
    }

    @Override
    public void onListFragmentLongClickInteraction(int position) {

    }

    @Override
    public void onDeleteClickInteraction(int position) {

    }

    private boolean phoneTest(String phone) {
        return android.util.Patterns.PHONE.matcher(phone).matches();
    }
    public boolean birthdayTest(String date)
    {
        SimpleDateFormat test = new SimpleDateFormat("dd/MM/yyyy");
        Date testDate = null;
        try
        {
            testDate = test.parse(date);
        }
        catch (ParseException e)
        {
            return false;
        }
        if (!test.format(testDate).equals(date))
        {
            return false;
        }
        return true;
    }
}
