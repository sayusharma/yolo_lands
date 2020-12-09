package com.e.yololands;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import java.util.ArrayList;

public class DashActivity extends AppCompatActivity {
    private ArrayList<Model> arrayList;
    private RecyclerView recyclerView;
    private MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);
        arrayList = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler);
        //SET PROPS
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //ADAPTER
        adapter=new MyAdapter(this,arrayList);

        //RETRIEVE
        retrieve();
    }
    private void retrieve() {
        arrayList.clear();
        DBAdapter db=new DBAdapter(this);
        db.openDB();
        //RETRIEVE
        Cursor c=db.getAllPlayers();

        //LOOP AND ADD TO ARRAYLIST
        while (c.moveToNext())
        {
            int id=c.getInt(0);
            String name=c.getString(1);
            String pos=c.getString(2);
            Model p=new Model(id,name,pos);

            //ADD TO ARRAYLIS
            arrayList.add(p);
        }
        //CHECK IF ARRAYLIST ISNT EMPTY
        if(!(arrayList.size()<1))
        {
            recyclerView.setAdapter(adapter);
        }

        db.closeDB();
    }
}