package com.example.harshit.threadsort;

import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b;Button b1;
    EditText e;
    TextView t;
int count,a;
    public void sort(View v) {
        String s = e.getText().toString();
        String[] values = s.split(" ");
        count=values.length; a=2;int sum=0;
        for (int i = 0; i < values.length; i++) {
            int x = Integer.parseInt(values[i]);
            sum+=x;
            MyRunnableThread mrt =
                    new MyRunnableThread(
                            x);
            Thread t = new Thread(mrt);
            t.start();
         // if(t.isAlive()) b.setEnabled(false);

        }

    }
    public void restart(View v){
        b.setEnabled(true);
        e.setText("");
        t.setText("");
    }
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = findViewById(R.id.button);
        e = findViewById(R.id.editText);
        t = findViewById(R.id.text);
        b1=findViewById(R.id.button2);
    }

    class MyRunnableThread implements Runnable  {

        public int data = 0;

        public MyRunnableThread(int data) {
            this.data = data;
        }
         Handler h=new Handler();
        public void run() {
            try {
                Thread.sleep(1000 * (data));
                h.post(new Runnable() {
                    @Override
                    public void run() {
                        t.setText(t.getText().toString()  +data +"  ");
                    }
                });

            } catch (InterruptedException iex) {
               // System.out.println("Exception in thread: " + iex.getMessage());
            }
        }
    }
}
