package com.game.triviaapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button playgame;
EditText e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playgame = (Button) findViewById(R.id.playbutton);
        e=findViewById(R.id.editTextName);
        playgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value=e.getText().toString();
                Intent intent = new Intent(MainActivity.this, questions.class);
                intent.putExtra("key", value);
                startActivity(intent);
            }
        });
    }

}