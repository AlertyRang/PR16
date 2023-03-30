package com.example.pr16;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView listChar;
    Button butt_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listChar = findViewById(R.id.recycler_view);
        butt_add = findViewById(R.id.button_add);

        butt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddActivity.class);
                startActivity(intent);
            }
        });

        DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
        listChar.setLayoutManager(new LinearLayoutManager(this));
        listChar.setHasFixedSize(true);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, dataBaseHelper.getCharacterList());
        listChar.setAdapter(adapter);
    }
}