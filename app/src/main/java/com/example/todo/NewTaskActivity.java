package com.example.todo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;
import java.util.Random;

public class NewTaskActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    TextView titlePage, addTitle, addDesc, addDate, titledoes, descdoes, datedoes;
    EditText titleTodo, descTodo;
    Button btnSave, btnCancel, datebtn;
    DatabaseReference reference;
    Integer todoNum = new Random().nextInt();
    String keydoes = Integer.toString(todoNum);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        //    referencing from xml all the attributes
        addTitle = findViewById(R.id.addTitle);
        addDesc = findViewById(R.id.addDesc);
        addDate = findViewById(R.id.addDate);


        titledoes = findViewById(R.id.titledoes);
        descdoes = findViewById(R.id.descdoes);
        datedoes = findViewById(R.id.datedoes);

        btnSave = findViewById(R.id.btnSave);
        btnCancel = findViewById(R.id.btnCancel);
        datebtn = findViewById(R.id.datebtn);

//        to show the date dialog when btn clicked
        datebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
//            insert data from form to database
                reference = FirebaseDatabase.getInstance().getReference().child("TodoApp").
                        child("Todo" + todoNum);
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        dataSnapshot.getRef().child("titledoes").setValue(titledoes.getText().toString());
                        dataSnapshot.getRef().child("descdoes").setValue(descdoes.getText().toString());
                        dataSnapshot.getRef().child("datedoes").setValue(datedoes.getText().toString());
                        dataSnapshot.getRef().child("keydoes").setValue(keydoes);

                        Intent intent = new Intent(NewTaskActivity.this, MainActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        System.out.print("hello");
                    }
                });
            }
        });

    }

//    to show the date
    private void showDatePicker(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = month + "-" + dayOfMonth + "-" + year;
        datedoes.setText(date);
    }
}

