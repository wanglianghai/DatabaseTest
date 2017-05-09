package com.bignerdranch.android.databasetest;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.bignerdranch.android.databasetest.BookSchemaDb.BookTable;

/**
 * Created by Administrator on 2017/5/9/009.
 */

public class BookCursorWrapper extends CursorWrapper {
    /**
     * Creates a cursor wrapper.
     *
     * @param cursor The underlying cursor to wrap.
     */
    public BookCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Book getBook() {
        String name = getString(getColumnIndex(BookTable.Cols.NAME));
        String author = getString(getColumnIndex(BookTable.Cols.AUTHOR));
        int pages = getInt(getColumnIndex(BookTable.Cols.PRICE));

        Book book = new Book(name, author, pages, 11.0f);
        return book;
    }
}
