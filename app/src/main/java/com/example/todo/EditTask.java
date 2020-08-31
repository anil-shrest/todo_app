package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

public class EditTask extends AppCompatActivity {

    EditText titleDoes, descDoes;
    TextView dateDoes;
    Button btnUpdate, btnDelete;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);

        titleDoes = findViewById(R.id.titledoes);
        descDoes = findViewById(R.id.descdoes);
        dateDoes = findViewById(R.id.datedoes);

        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);

//        getting value from previous screen
        titleDoes.setText(getIntent().getStringExtra("titledoes"));
        descDoes.setText(getIntent().getStringExtra("descdoes"));
        dateDoes.setText(getIntent().getStringExtra("datedoes"));

//        event for buttons
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}