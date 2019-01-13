package com.example.danni.a24;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

public class branch2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final int[] NumArray=new int[4];

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch2);
        final EditText editText2=(EditText)findViewById(R.id.editText2); //read


        final EditText editText3=(EditText)findViewById(R.id.editText3); //read


        final EditText editText4=(EditText)findViewById(R.id.editText4); //read




        final EditText editText5=(EditText)findViewById(R.id.editText5); //read







        Button button6=(Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i=new Intent(branch2.this,branch2.class);
                startActivity(i);
            }

        });




        Button button5=(Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){


                int result;
                result=Integer.valueOf(editText2.getText().toString());
                if(result>10||result<1){
                    editText2.setText("");
                    Toast.makeText(branch2.this, "Please enter the number from 1 to 10" ,Toast.LENGTH_SHORT).show();
                }else {
                    NumArray[0] =result;//input
                }//4 times



                result=Integer.valueOf(editText3.getText().toString());
                if(result>10||result<1){
                    editText3.setText("");
                    Toast.makeText(branch2.this, "Please enter the number from 1 to 10" ,Toast.LENGTH_SHORT).show();
                }else {
                    NumArray[1] =result;//input
                }//4 times


                result=Integer.valueOf(editText4.getText().toString());
                if(result>10||result<1){
                    editText4.setText("");
                    Toast.makeText(branch2.this, "Please enter the number from 1 to 10" ,Toast.LENGTH_SHORT).show();
                }else {
                    NumArray[2] =result;//input
                }//4 times




                result=Integer.valueOf(editText5.getText().toString());
                if(result>10||result<1){
                    editText5.setText("");
                    Toast.makeText(branch2.this, "Please enter the number from 1 to 10" ,Toast.LENGTH_SHORT).show();
                }else {
                    NumArray[3] =result;//input
                }//4 times





                String yes=Make.cheat(NumArray);//boom it out
                Toast.makeText(branch2.this, ""+yes ,Toast.LENGTH_SHORT).show();

            }

        });





    }

}
