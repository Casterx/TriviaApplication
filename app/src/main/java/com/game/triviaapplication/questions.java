package com.game.triviaapplication;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class questions extends AppCompatActivity {
    String newString;
    RadioGroup radioGroup;
    RadioButton selectedRadioButton;
    String radio,s;
    Button scorebtn;
    CheckBox ONE,TWO,THREE,FOUR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        ONE = (CheckBox)findViewById(R.id.checkBox);
        TWO = (CheckBox)findViewById(R.id.checkBox2);
        THREE = (CheckBox)findViewById(R.id.checkBox3);
        FOUR = (CheckBox)findViewById(R.id.checkBox4);
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newString= null;
            } else {
                newString= extras.getString("key");
            }
        } else {
            newString= (String) savedInstanceState.getSerializable("key");
        }
        scorebtn = (Button) findViewById(R.id.scorebtn);
        scorebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioGroup = findViewById(R.id.radioGroup);
                int selectedId = radioGroup.getCheckedRadioButtonId();

                if (selectedId != -1) {
                    selectedRadioButton = findViewById(selectedId);
                    String selectedRbText = selectedRadioButton.getText().toString();
                    radio=(selectedRbText);
                } else {
                    radio=("Nothing selected from the radio group");
                }
                if(ONE.isChecked())
                {
                   s=ONE.getText().toString();
                }
                else {
                    s="";
                }   if(TWO.isChecked())
                {
                    s=s+","+TWO.getText().toString();
                }
                else {
                    s=s+"";
                }
                if(THREE.isChecked())
                {
                    s=s+","+THREE.getText().toString();
                }
                else {
                    s=s+"";
                }
                if(FOUR.isChecked())
                {
                    s=s+","+FOUR.getText().toString();
                }
                else {
                    s=s+"";
                }
                Intent intent = new Intent(questions.this, Scoring.class);
                intent.putExtra("key1", newString);
                intent.putExtra("key2", radio);
                intent.putExtra("key3", s);
                startActivity(intent);
            }
        });

    }
}