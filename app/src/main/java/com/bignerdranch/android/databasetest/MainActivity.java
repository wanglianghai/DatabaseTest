package com.bignerdranch.android.databasetest;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bignerdranch.android.databasetest.BookSchemaDb.BookTable;

public class MainActivity extends AppCompatActivity {
    private Button mButtonCreateDatabase;
    private Button mButtonAddBook;
    private Button mButtonUpdateBook;
    private Button mButtonDelete;
    private SQLiteDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDatabase = new MyDatabaseHelper(getApplicationContext()).getWritableDatabase();

        mButtonCreateDatabase = (Button) findViewById(R.id.create_database_button);
        mButtonCreateDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        mButtonAddBook = (Button) findViewById(R.id.add_book);
        mButtonAddBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book("The Da Vin Code", "Dan Brown", 454, 16.96f);
                mDatabase.insert(BookTable.NAME, null, Book.getContentValue(book));
            }
        });

        mButtonUpdateBook = (Button) findViewById(R.id.update_book);
        mButtonUpdateBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book("The Da Vin Code", "Dan Brown", 333, 10.96f);
                // Which row to update, based on the title
                String selection = BookTable.Cols.NAME + " = ?";
                String[] selectionArgs = { "The Da Vin Code" };
                book.update(book, selection, selectionArgs, mDatabase);
            }
        });

        mButtonDelete = (Button) findViewById(R.id.delete_book);
        mButtonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selection = BookTable.Cols.PAGES + " < ? ";
                String[] selectionArgs = { "500" };
                Book.delete(selection, selectionArgs, mDatabase);
            }
        });
    }
}
