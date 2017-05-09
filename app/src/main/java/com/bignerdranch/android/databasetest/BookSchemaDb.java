package com.bignerdranch.android.databasetest;

/**
 * Created by Administrator on 2017/5/8/008.
 */

public final class BookSchemaDb {
    private BookSchemaDb(){}
    public static final class CategoryTable {
        public static final String NAME = "Category";

        public static final class Cols {
            public static final String CATEGORY_NAME = "category_name";
            public static final String CATEGORY_CODE = "category_code";
        }
    }
    public static final class BookTable {
        public static final String NAME = "Book";

        public static final class Cols {
            public static final String AUTHOR = "author";
            public static final String PRICE = "price";
            public static final String PAGES = "pages";
            public static final String NAME = "name";
        }
    }
}
