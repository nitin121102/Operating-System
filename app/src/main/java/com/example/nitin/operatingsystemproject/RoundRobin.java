package com.example.nitin.operatingsystemproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class RoundRobin extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round_robin);
    }
    public void press(View view)
    {   int n=5;
        int i,j,k,sum;
        int bt[]=new int[n];
        int wt[]=new int[n];
        int tat[]=new int[n];
        int a[]=new int[n];

        EditText e1=(EditText)findViewById(R.id.bt1);
        EditText e2=(EditText)findViewById(R.id.bt2);
        EditText e3=(EditText)findViewById(R.id.bt3);
        EditText e4=(EditText)findViewById(R.id.bt4);
        EditText e5=(EditText)findViewById(R.id.bt5);


        String es1=e1.getText().toString();
        String es2=e2.getText().toString();
        String es3=e3.getText().toString();
        String es4=e4.getText().toString();
        String es5=e5.getText().toString();



        int eis1= Integer.parseInt(es1);
        int eis2= Integer.parseInt(es2);
        int eis3= Integer.parseInt(es3);
        int eis4= Integer.parseInt(es4);
        int eis5= Integer.parseInt(es5);

        bt[0]=eis1;
        bt[1]=eis2;
        bt[2]=eis3;
        bt[3]=eis4;
        bt[4]=eis5;

        EditText tq2=(EditText)findViewById(R.id.tq);
        String tq1=e1.getText().toString();
        int q= Integer.parseInt(tq1);


        for(i=0;i<n;i++)
            a[i]=bt[i];

        for(i=0;i<n;i++)
            wt[i]=0;
        do
        {
            for(i=0;i<n;i++)
            {
                if(bt[i]>q)
                {
                    bt[i]-=q;
                    for(j=0;j<n;j++)
                    {
                        if((j!=i)&&(bt[j]!=0))
                            wt[j]+=q;
                    }
                }
                else
                {
                    for(j=0;j<n;j++)
                    {
                        if((j!=i)&&(bt[j]!=0))
                            wt[j]+=bt[i];
                    }
                    bt[i]=0;
                }
            }
            sum=0;
            for(k=0;k<n;k++)
                sum=sum+bt[k];
        }
        while(sum!=0);
        for(i=0;i<n;i++)
            tat[i]=wt[i]+a[i];


        float avg_wt=0;
        float avg_tat=0;
        for(j=0;j<n;j++)
        {
            avg_wt+=wt[j];
        }
        for(j=0;j<n;j++)
        {
            avg_tat+=tat[j];
        }



        int w1=wt[0];
        int w2=wt[1];
        int w3=wt[2];
        int w4=wt[3];
        int w5=wt[4];

        int tat1=tat[0];
        int tat2=tat[1];
        int tat3=tat[2];
        int tat4=tat[3];
        int tat5=tat[4];


        TextView t1=(TextView)findViewById(R.id.wt1);
        TextView t2=(TextView)findViewById(R.id.wt2);
        TextView t3=(TextView)findViewById(R.id.wt3);
        TextView t4=(TextView)findViewById(R.id.wt4);
        TextView t5=(TextView)findViewById(R.id.wt5);

        TextView tat11=(TextView)findViewById(R.id.tat1);
        TextView tat12=(TextView)findViewById(R.id.tat2);
        TextView tat13=(TextView)findViewById(R.id.tat3);
        TextView tat14=(TextView)findViewById(R.id.tat4);
        TextView tat15=(TextView)findViewById(R.id.tat5);


        TextView awt1=(TextView)findViewById(R.id.awt);
        TextView atat1=(TextView)findViewById(R.id.atat);

        String s1=Integer.toString(w1);
        String s2=Integer.toString(w2);
        String s3=Integer.toString(w3);
        String s4=Integer.toString(w4);
        String s5=Integer.toString(w5);


        String ts1=Integer.toString(tat1);
        String ts2=Integer.toString(tat2);
        String ts3=Integer.toString(tat3);
        String ts4=Integer.toString(tat4);
        String ts5=Integer.toString(tat5);
        Float x=avg_wt/5;
        Float y=avg_tat/5;

        String awt2=Float.toString(x);
        String atat2=Float.toString(y);
        awt1.setText(awt2);
        atat1.setText(atat2);

        tat11.setText(ts1);
        tat12.setText(ts2);
        tat13.setText(ts3);
        tat14.setText(ts4);
        tat15.setText(ts5);

        t1.setText(s1);
        t2.setText(s2);
        t3.setText(s3);
        t4.setText(s4);
        t5.setText(s5);



    }}
