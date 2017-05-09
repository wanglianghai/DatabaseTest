package com.bignerdranch.android.databasetest;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.bignerdranch.android.databasetest.BookSchemaDb.BookTable;

/**
 * Created by Administrator on 2017/5/9/009.
 */

public class Book {
    private String mStringName;
    private String mStringAuthor;
    private int mIntPages;
    private float mFloatPrice;
    private SQLiteDatabase mDatabase;

    public Book(String stringName, String stringAuthor, int intPages, float floatPrice) {
        mStringName = stringName;
        mStringAuthor = stringAuthor;
        mIntPages = intPages;
        mFloatPrice = floatPrice;
    }

    public Book(String stringName, String stringAuthor, int intPages, float floatPrice, Context context) {
        mStringName = stringName;
        mStringAuthor = stringAuthor;
        mIntPages = intPages;
        mFloatPrice = floatPrice;
        mDatabase = new MyDatabaseHelper(context).getWritableDatabase();
    }

    public static ContentValues getContentValue(Book book) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(BookTable.Cols.AUTHOR, book.getStringAuthor());
        contentValues.put(BookTable.Cols.NAME, book.getStringName());
        contentValues.put(BookTable.Cols.PAGES, book.getFloatPrice());
        contentValues.put(BookTable.Cols.PAGES, book.getIntPages());
        return contentValues;
    }

    public void update(Book book, String selection, String[] selectionArgs, SQLiteDatabase db) {
        // Which row to update, based on the title
        ContentValues values = getContentValue(book);
        db.update(BookTable.NAME, values, selection, selectionArgs);
    }

    public static void delete(String selection, String[] selectionArgs, SQLiteDatabase db) {
        db.delete(BookTable.NAME, selection, selectionArgs);
    }

    public String getStringName() {
        return mStringName;
    }

    public void setStringName(String stringName) {
        mStringName = stringName;
    }

    public String getStringAuthor() {
        return mStringAuthor;
    }

    public void setStringAuthor(String stringAuthor) {
        mStringAuthor = stringAuthor;
    }

    public int getIntPages() {
        return mIntPages;
    }

    public void setIntPages(int intPages) {
        mIntPages = intPages;
    }

    public float getFloatPrice() {
        return mFloatPrice;
    }

    public void setFloatPrice(float floatPrice) {
        mFloatPrice = floatPrice;
    }
}
