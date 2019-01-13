package com.example.danni.a24;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

public class branch1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final int[] NumArray=new int[4];

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch1);
final TextView card1=(TextView)findViewById(R.id.card1);
NumArray[0]=(int)(Math.random()*10)+1;
card1.setText(""+NumArray[0]);
        final TextView card2=(TextView)findViewById(R.id.card2);
        NumArray[1]=(int)(Math.random()*10)+1;
        card2.setText(""+NumArray[1]);

        final TextView card3=(TextView)findViewById(R.id.card3);
        NumArray[2]=(int)(Math.random()*10)+1;
        card3.setText(""+NumArray[2]);
        final TextView card4=(TextView)findViewById(R.id.card4);
        NumArray[3]=(int)(Math.random()*10)+1;
        card4.setText(""+ NumArray[3]);

        Button button4=(Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i=new Intent(branch1.this,branch1.class);
                startActivity(i);
            }

        });

        Button button3=(Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

             String result=Make.cheat(NumArray);//boom it out
                Toast.makeText(branch1.this, ""+result ,Toast.LENGTH_SHORT).show();

            }

        });





    }

}


