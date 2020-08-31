package com.example.todo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.MyViewHolder> {

    Context context;
    ArrayList<MyTodo> myTodo;

    public TodoAdapter(Context c, ArrayList<MyTodo> p){
        context = c;
        myTodo = p;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_does,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        myViewHolder.titledoes.setText(myTodo.get(i).getTitledoes());
        myViewHolder.descdoes.setText(myTodo.get(i).getDescdoes());
        myViewHolder.datedoes.setText(myTodo.get(i).getDatedoes());
        myViewHolder.keydoes.setText(myTodo.get(i).getKeytodo());

//        to pass the details to next intent
        final String getTitleDoes = myTodo.get(i).getTitledoes();
        final String getDescDoes = myTodo.get(i).getDescdoes();
        final String getDateDoes = myTodo.get(i).getDatedoes();
        final String getKeytodo = myTodo.get(i).getKeytodo();

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(context, EditTask.class);
                intent.putExtra("titledoes", getTitleDoes);
                intent.putExtra("descdoes", getDescDoes);
                intent.putExtra("datedoes", getDateDoes);
                intent.putExtra("keydoes", getKeytodo);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {

        return myTodo.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView titledoes, descdoes, datedoes, keydoes;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titledoes = (TextView) itemView.findViewById(R.id.titledoes);
            descdoes = (TextView) itemView.findViewById(R.id.descdoes);
            datedoes = (TextView) itemView.findViewById(R.id.datedoes);
        }
    }

}
