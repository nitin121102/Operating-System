package com.example.nitin.operatingsystemproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Fcfs(View view)
    {
        Intent i=new Intent(this,Fcfs.class);
        startActivity(i);
    }
    public void prioritynp(View view)
    {
        Intent i=new Intent(this,PriorityNP.class);
        startActivity(i);

    }
    public void round(View view)
    {
        Intent i=new Intent(this,RoundRobin.class);
        startActivity(i);
    }
    public void sjfnp(View view)
    {
        Intent i=new Intent(this,SjfNP.class);
        startActivity(i);
    }
    public void sjfp(View view)
    {
        Intent i=new Intent(this,SjfP.class);
        startActivity(i);
    }


}
