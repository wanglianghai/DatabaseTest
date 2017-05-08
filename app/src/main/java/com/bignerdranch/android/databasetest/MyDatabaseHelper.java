package com.bignerdranch.android.databasetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.bignerdranch.android.databasetest.BookSchemaDb.BookTable;

/**
 * Created by Administrator on 2017/5/8/008.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String CREATE_BOOK = "create table " + BookTable.NAME + " ( "
            + "id integer primary key autoincrement, "
            + BookTable.Cols.AUTHOR + " text, "
            + BookTable.Cols.PRICE + " real, "
            + BookTable.Cols.PAGES + " integer, "
            + BookTable.Cols.NAME + " text)";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "BookStore.db";

    private Context mContext;

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BOOK);
        Toast.makeText(mContext, "Create database succeeded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
