package com.raphaelsmadja.connection;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;

import java.util.regex.Pattern;


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
        isValidEmail(editEmailValue);
    }

    public static final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" + "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
    );

    private boolean isValidEmail(String email) {
        if (TextUtils.isEmpty(email)) {
            return false;
        } else {
            return EMAIL_ADDRESS_PATTERN.matcher(email).matches();
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
