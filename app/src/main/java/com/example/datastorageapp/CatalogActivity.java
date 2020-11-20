package com.example.datastorageapp;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.datastorageapp.Data.DataContract;
import com.example.datastorageapp.Data.DataDbHelper;

public class CatalogActivity extends AppCompatActivity {
    private DataDbHelper mDbHelper;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_catalog);
        displayDatabaseInfo();
        mDbHelper = new DataDbHelper(this);
    }
    public void fabAction(View view){
        Intent intent = new Intent(CatalogActivity.this, EditorActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        displayDatabaseInfo();
    }

    private void displayDatabaseInfo() {
        // Create and/or open a database to read from it
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                DataContract.DataEntry._ID,
                DataContract.DataEntry.COLUMN_CAFE_NAME,
                DataContract.DataEntry.COLUMN_CAFE_ADDRESS ,
                DataContract.DataEntry.COLUMN_CAFE_RATINGS,
                DataContract.DataEntry.COLUMN_CAFE_AVG_BILL,
                DataContract.DataEntry.COLUMN_CAFE_COMMENT
        };

        // Perform a query on the pets table
        Cursor cursor = db.query(
                DataContract.DataEntry.TABLE_NAME,   // The table to query
                projection,            // The columns to return
                null,                  // The columns for the WHERE clause
                null,                  // The values for the WHERE clause
                null,                  // Don't group the rows
                null,                  // Don't filter by row groups
                null);                   // The sort order

        TextView displayView = (TextView) findViewById(R.id.text_view_pet);

        try {
            // Create a header in the Text View that looks like this:
            //
            // The pets table contains <number of rows in Cursor> pets.
            // _id - name - breed - gender - weight
            //
            // In the while loop below, iterate through the rows of the cursor and display
            // the information from each column in this order.
            displayView.setText("The pets table contains " + cursor.getCount() + " pets.\n\n");
            displayView.append(DataContract.DataEntry._ID + " - " +
                    DataContract.DataEntry.COLUMN_CAFE_NAME + " - " +
                    DataContract.DataEntry.COLUMN_CAFE_ADDRESS + " - " +
                    DataContract.DataEntry.COLUMN_CAFE_RATINGS + " - " +
                    DataContract.DataEntry.COLUMN_CAFE_AVG_BILL + " - " +
                    DataContract.DataEntry.COLUMN_CAFE_COMMENT + "\n");

            // Figure out the index of each column
            int idColumnIndex = cursor.getColumnIndex(DataContract.DataEntry._ID);
            int nameColumnIndex = cursor.getColumnIndex(DataContract.DataEntry.COLUMN_CAFE_NAME);
            int addressColumnIndex = cursor.getColumnIndex(DataContract.DataEntry.COLUMN_CAFE_ADDRESS);
            int ratingsColumnIndex = cursor.getColumnIndex(DataContract.DataEntry.COLUMN_CAFE_RATINGS);
            int billColumnIndex = cursor.getColumnIndex(DataContract.DataEntry.COLUMN_CAFE_AVG_BILL);
            int commentColumnIndex = cursor.getColumnIndex(DataContract.DataEntry.COLUMN_CAFE_COMMENT);

            // Iterate through all the returned rows in the cursor
            while (cursor.moveToNext()) {
                // Use that index to extract the String or Int value of the word
                // at the current row the cursor is on.
                int currentID = cursor.getInt(idColumnIndex);
                String currentName = cursor.getString(nameColumnIndex);
                String currentAddress = cursor.getString(addressColumnIndex);
                int currentRatings = cursor.getInt(ratingsColumnIndex);
                int currentBill = cursor.getInt(billColumnIndex);
                String currentComment = cursor.getString(commentColumnIndex);
                // Display the values from each column of the current row in the cursor in the TextView
                displayView.append(("\n" + currentID + " - " +
                        currentName + " - " +
                        currentAddress + " - " +
                        currentRatings + " - " +
                        currentBill + " - " +
                        currentComment));
            }
        } finally {
            cursor.close();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_catalog, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_insert_data:
                insertData();
                finish();
                return true;
            case R.id.action_delete_data:
                deleteData();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void deleteData() {
    }

    private void insertData() {
    }
}
