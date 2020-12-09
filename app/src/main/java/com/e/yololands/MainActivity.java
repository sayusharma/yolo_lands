package com.e.yololands;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        delete();
        save("AGRICULTURAL","NARELA,DELHI");
        save("ILLEGAL","VASANT VIHAR, DELHI");
        save("NON-AGRICULTURAL","CONNAUGHT PLACE, DELHI");
        save("ILLEGAL","SINGHU BORDER, DELHI");
        save("AGRICULTURAL","GTB NAGAR, DELHI");
        save("NON-AGRICULTURAL","ROHINI, DELHI");
    }
    private void save(String name,String pos)
    {
        DBAdapter db=new DBAdapter(this);

        //OPEN DB
        db.openDB();
        //COMMIT
        long result=db.add(name,pos);

        if(result>0)
        {
            Toast.makeText(getApplicationContext(),"BUDGET ADDED!",Toast.LENGTH_SHORT).show();
        }
        db.closeDB();

    }
    private void delete(){
        DBAdapter db=new DBAdapter(this);
        db.deleteDB();
    }
    public void onClickLogin(View view){
        Intent intent = new Intent(MainActivity.this,DashActivity.class);
        startActivity(intent);
    }
    public void onClickRegister(View view){
        Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
        startActivity(intent);
    }
}