package com.example.pr16;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {
    EditText charName, charClass;
    Button addChar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        charName = findViewById(R.id.char_name);
        charClass = findViewById(R.id.char_class);
        addChar = findViewById(R.id.char_add);

        DataBaseHelper dataBaseHelper = new DataBaseHelper(this);

        addChar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Character character = new Character(0, charName.getText().toString(), charClass.getText().toString());

                dataBaseHelper.addCharacter(character);
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}