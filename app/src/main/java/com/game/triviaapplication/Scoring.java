package com.game.triviaapplication;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class Scoring extends AppCompatActivity{
    private TextView name;
    String newString,radio,check;
    TextView ans1,ans2;
    Button play;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoring2);
        name = findViewById(R.id.name);
        ans1= findViewById(R.id.ans1);
        ans2= findViewById(R.id.ans2);
        play=findViewById(R.id.playagain);
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newString= null;
                radio=null;
            } else {
                newString= extras.getString("key1");
                radio= extras.getString("key2");
                check= extras.getString("key3");

            }
        } else {
            newString= (String) savedInstanceState.getSerializable("key1");
            radio= (String) savedInstanceState.getSerializable("key2");
            check= (String) savedInstanceState.getSerializable("key3");
        }
        name.setText(newString);
        ans1.setText(radio);
        ans2.setText(check);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Scoring.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


}