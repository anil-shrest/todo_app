package com.example.todo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView titlepage, subtitlepage, endpage;
    Button btnAddNew;

    DatabaseReference reference;
    RecyclerView ourdoes;
    ArrayList<MyTodo> list;
    TodoAdapter todoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titlepage = findViewById(R.id.titlePage);
        subtitlepage = findViewById(R.id.subtitlepage);
        endpage = findViewById(R.id.endpage);

        btnAddNew = findViewById(R.id.btnAddNew);

        btnAddNew.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, NewTaskActivity.class);
                startActivity(intent);
            }
        });

////        importing font
//        Typeface normal = Typeface.createFromAsset(getAssets(), "@font/regular.ttf");
//        Typeface medium = Typeface.createFromAsset(getAssets(), "@font/medium.ttf");
//
////        customizing fonts
//        titlepage.setTypeface(medium);
//        subtitlepage.setTypeface(normal);
//        endpage.setTypeface(normal);

//        working with the data
        ourdoes = findViewById(R.id.ourdoes);
        ourdoes.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<MyTodo>();

//        get data from firebase
        reference = FirebaseDatabase.getInstance().getReference().child("TodoApp");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
//            set code to retrive data and replace layout
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    MyTodo p = dataSnapshot1.getValue(MyTodo.class);
                    list.add(p);
                }
                todoAdapter = new TodoAdapter(MainActivity.this, list);
                ourdoes.setAdapter(todoAdapter);
                todoAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
//                set code to show error
                Toast.makeText(getApplicationContext(), "No data", Toast.LENGTH_SHORT).show();
            }
        });

    }
}