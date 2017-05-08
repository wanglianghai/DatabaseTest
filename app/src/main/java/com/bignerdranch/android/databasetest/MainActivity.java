package com.bignerdranch.android.databasetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mButtonCreateDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonCreateDatabase = (Button) findViewById(R.id.create_database_button);
        mButtonCreateDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper mdh = new MyDatabaseHelper(getApplicationContext());
                mdh.getWritableDatabase();
            }
        });
    }
}
