package com.example.nitin.operatingsystemproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Fcfs extends AppCompatActivity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_fcfs);

        }

    public void press(View view)
    {     int n=5;
        int pid[] = new int[n];   // process ids
        int AT[] = new int[n];     // arrival times
        int BT[] = new int[n];     // burst or execution times
        int CT[] = new int[n];     // completion times
        int TAT[] = new int[n];     // turn around times
        int WT[] = new int[n];     // waiting times
        int temp;
        float AWT=0,ATAT1=0;
        float TWT=0,TTAT=0;
        EditText e1=(EditText)findViewById(R.id.bt1);
        EditText e2=(EditText)findViewById(R.id.bt2);
        EditText e3=(EditText)findViewById(R.id.bt3);
        EditText e4=(EditText)findViewById(R.id.bt4);
        EditText e5=(EditText)findViewById(R.id.bt5);

        EditText p1=(EditText)findViewById(R.id.p1);
        EditText p2=(EditText)findViewById(R.id.p2);
        EditText p3=(EditText)findViewById(R.id.p3);
        EditText p4=(EditText)findViewById(R.id.p4);
        EditText p5=(EditText)findViewById(R.id.p5);

        String es1=e1.getText().toString();
        String es2=e2.getText().toString();
        String es3=e3.getText().toString();
        String es4=e4.getText().toString();
        String es5=e5.getText().toString();

        String ep1=p1.getText().toString();
        String ep2=p2.getText().toString();
        String ep3=p3.getText().toString();
        String ep4=p4.getText().toString();
        String ep5=p5.getText().toString();


        int eis1= Integer.parseInt(es1);
        int eis2= Integer.parseInt(es2);
        int eis3= Integer.parseInt(es3);
        int eis4= Integer.parseInt(es4);
        int eis5= Integer.parseInt(es5);

        int eip1= Integer.parseInt(ep1);
        int eip2= Integer.parseInt(ep2);
        int eip3= Integer.parseInt(ep3);
        int eip4= Integer.parseInt(ep4);
        int eip5= Integer.parseInt(ep5);
        BT[0]=eis1;
        BT[1]=eis2;
        BT[2]=eis3;
        BT[3]=eis4;
        BT[4]=eis5;

        AT[0]=eip1;
        AT[1]=eip2;
        AT[2]=eip3;
        AT[3]=eip4;
        AT[4]=eip5;
//sorting according to arrival times
        for(int i = 0 ; i <n; i++)
        {
            for(int  j=0;  j < n-(i+1) ; j++)
            {
                if( AT[j] > AT[j+1] )
                {
                    temp = AT[j];
                    AT[j] = AT[j+1];
                    AT[j+1] = temp;
                    temp = BT[j];
                    BT[j] = BT[j+1];
                    BT[j+1] = temp;
                    temp = pid[j];
                    pid[j] = pid[j+1];
                    pid[j+1] = temp;
                }
            }
        }

        // finding completion times
        for(int  i = 0 ; i < n; i++)
        {
            if( i == 0)
            {
                CT[i] = AT[i] + BT[i];
            }
            else
            {
                if( AT[i] > CT[i-1])
                {
                    CT[i] = AT[i] + BT[i];
                }
                else
                    CT[i] = CT[i-1] + BT[i];
            }
            TAT[i] = CT[i] - AT[i] ;          // turnaround time= completion time- arrival time
            WT[i] = TAT[i] - BT[i] ;          // waiting time= turnaround time- burst time
            TWT += WT[i] ;               // total waiting time
            TTAT += TAT[i] ;               // total turnaround time
        }


        int w1=WT[0];
        int w2=WT[1];
        int w3=WT[2];
        int w4=WT[3];
        int w5=WT[4];

        int tat1=TAT[0];
        int tat2=TAT[1];
        int tat3=TAT[2];
        int tat4=TAT[3];
        int tat5=TAT[4];

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
        float a=TWT/5;
        float b=TTAT/5;

        String awt2=Float.toString(a);
        String atat2=Float.toString(b);
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




    }


}
