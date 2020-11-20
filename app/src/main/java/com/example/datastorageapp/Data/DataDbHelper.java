package com.example.datastorageapp.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataDbHelper extends SQLiteOpenHelper {
    public static final String LOG_TAG = DataDbHelper.class.getSimpleName();
    private static final String DATABASE_NAME = "cafe.db";
    private static final int DATABASE_VERSION = 1;

    public DataDbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_CAFE_TABLE =  "CREATE TABLE " + DataContract.DataEntry.TABLE_NAME + " ("
                + DataContract.DataEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DataContract.DataEntry.COLUMN_CAFE_NAME + " TEXT NOT NULL, "
                + DataContract.DataEntry.COLUMN_CAFE_ADDRESS + " TEXT, "
                + DataContract.DataEntry.COLUMN_CAFE_RATINGS + " INTEGER, "
                + DataContract.DataEntry.COLUMN_CAFE_AVG_BILL + " INTEGER DEFAULT 0,"
                + DataContract.DataEntry.COLUMN_CAFE_COMMENT + " TEXT );";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_CAFE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
//        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
