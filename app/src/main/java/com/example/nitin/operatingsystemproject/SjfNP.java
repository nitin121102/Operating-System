package com.example.nitin.operatingsystemproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SjfNP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sjf_np);
    }

    public void press(View view)
    { int n=5;
        int pid[] = new int[n];
        int at[] = new int[n]; // at means arrival time
        int bt[] = new int[n]; // bt means burst time
        int ct[] = new int[n]; // ct means complete time
        int ta[] = new int[n]; // ta means turn around time
        int wt[] = new int[n];  //wt means waiting time
        int f[] = new int[n];  // f means it is flag it checks process is completed or not
        int st=0, tot=0;
        float avgwt=0, avgta=0;


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


        bt[0]=eis1;
        bt[1]=eis2;
        bt[2]=eis3;
        bt[3]=eis4;
        bt[4]=eis5;

        at[0]=eip1;
        at[1]=eip2;
        at[2]=eip3;
        at[3]=eip4;
        at[4]=eip5;


        for(int i=0;i<n;i++)
        {

            pid[i] = i+1;
            f[i] = 0;
        }
        boolean a = true;
        while(true)
        {
            int c=n, min=999;
            if (tot == n) // total no of process = completed process loop will be terminated
                break;

            for (int i=0; i<n; i++)
            {
				/*
				 * If i'th process arrival time <= system time and its flag=0 and burst<min
				 * That process will be executed first
				 */
                if ((at[i] <= st) && (f[i] == 0) && (bt[i]<min))
                {
                    min=bt[i];
                    c=i;
                }
            }

			/* If c==n means c value can not updated because no process arrival time< system time so we increase the system time */
            if (c==n)
                st++;
            else
            {
                ct[c]=st+bt[c];
                st+=bt[c];
                ta[c]=ct[c]-at[c];
                wt[c]=ta[c]-bt[c];
                f[c]=1;
                tot++;
            }
        }

        for(int i=0;i<n;i++)
        {
            avgwt+= wt[i];
            avgta+= ta[i];
        }
        int w1=wt[0];
        int w2=wt[1];
        int w3=wt[2];
        int w4=wt[3];
        int w5=wt[4];

        int tat1=ta[0];
        int tat2=ta[1];
        int tat3=ta[2];
        int tat4=ta[3];
        int tat5=ta[4];

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
        float m=avgwt/5;
        float b=avgta/5;

        String awt2=Float.toString(m);
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
