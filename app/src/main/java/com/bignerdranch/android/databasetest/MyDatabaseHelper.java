package com.bignerdranch.android.databasetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.bignerdranch.android.databasetest.BookSchemaDb.BookTable;
import com.bignerdranch.android.databasetest.BookSchemaDb.CategoryTable;

/**
 * Created by Administrator on 2017/5/8/008.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String CREATE_BOOK = "create table " + BookTable.NAME + " ( "
            + "id integer primary key autoincrement, "
            + BookTable.Cols.AUTHOR + " text, "
            + BookTable.Cols.PRICE + " float, "
            + BookTable.Cols.PAGES + " integer, "
            + BookTable.Cols.NAME + " text)";
    private static final String CREATE_CATEGORY = "create table " + CategoryTable.NAME + " ( "
            + "id integer primary key autoincrement, "
            + CategoryTable.Cols.CATEGORY_CODE + " integer, "
            + CategoryTable.Cols.CATEGORY_NAME + " text)";
    private static final int DATABASE_VERSION = 5;
    private static final String SQL_DELETE_BOOK =
            "DROP TABLE IF EXISTS " + BookTable.NAME;
    private static final String SQL_DELETE_CATEGORY =
            "DROP TABLE IF EXISTS " + CategoryTable.NAME;
    private static final String DATABASE_NAME = "BookStore.db";

    private Context mContext;

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BOOK);
        db.execSQL(CREATE_CATEGORY);
        Book book = new Book("The Da Vin Cook", "Dan red", 555, 16.96f);
        db.insert(BookSchemaDb.BookTable.NAME, null, Book.getContentValue(book));
        Toast.makeText(mContext, "Create database succeeded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_BOOK);
        db.execSQL(SQL_DELETE_CATEGORY);
        onCreate(db);
    }
}
