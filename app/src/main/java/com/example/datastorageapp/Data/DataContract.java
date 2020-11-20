package com.example.datastorageapp.Data;

import android.provider.BaseColumns;

public final class DataContract {
    public DataContract() {
    }

    public static final class DataEntry implements BaseColumns{
        public static final String TABLE_NAME = "cafe";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_CAFE_NAME = "name";
        public static final String COLUMN_CAFE_ADDRESS = "address";
        public static final String COLUMN_CAFE_RATINGS = "ratings";
        public static final String COLUMN_CAFE_AVG_BILL = "bill";
        public static final String COLUMN_CAFE_COMMENT = "comment";
    }
}

