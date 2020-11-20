package com.example.datastorageapp;

import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EditorActivity extends AppCompatActivity {

    private EditText mNameEditText;
    private EditText mAddressEditText;
    private EditText mRatingsEditText;
    private EditText mBillEditText;
    private EditText mCommentEditText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.id.activity_editor);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_editor, menu);
        return true;
    }

}
