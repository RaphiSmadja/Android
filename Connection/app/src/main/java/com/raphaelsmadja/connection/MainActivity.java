package com.raphaelsmadja.connection;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void saveDonne(View view){
        EditText emailText = (EditText) findViewById(R.id.emailText);
        String editEmailValue = emailText.getText().toString();
        EditText passwordText = (EditText) findViewById(R.id.passwordText);
        String editPasswordValue = passwordText.getText().toString();
        testCheckEmail(editEmailValue);
    }

    public boolean testCheckEmail(String editEmailValue){
        if (editEmailValue.isEmpty()) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

    public void saveDatabase(View view){
        SQLiteDatabase db;
        try {
            DatabaseHelper databaseHelper = new DatabaseHelper(this, DatabaseHelper.DB_NAME, DatabaseHelper.DB_VERSION);
            db = databaseHelper.getWritableDatabase();
        } catch (SQLiteException e){
            db = openOrCreateDatabase(DatabaseHelper.DB_NAME, MODE_APPEND,null);
        }
    }

}
