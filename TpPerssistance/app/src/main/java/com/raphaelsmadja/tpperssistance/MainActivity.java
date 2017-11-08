package com.raphaelsmadja.tpperssistance;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    public static final String MY_PREF = "my_pref";
    public static final String MY_DATE = "MY_DATE";
    public static final String MY_CACHE_TXT = "my_cache.txt";
    public static final String MY_FILE_TXT = "my_file.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void savePreferences(View view) {
        SharedPreferences sharedPreferences =  //getPreferences(MODE_APPEND); // pref per Activity
                getSharedPreferences(MY_PREF, MODE_APPEND);
        long date = new Date().getTime(); // retourne le nombre de seconde depuis 1870
        sharedPreferences.edit().putLong(MY_DATE,date).commit();
    }

    public void startSecondActivity(View view) {
        startActivity(new Intent(this, SecondActivity.class));
    }

    public void saveCache(View view) {
        File cacheDir = getCacheDir();
        File cacheFile = new File(cacheDir, MY_CACHE_TXT);
        try {
            FileOutputStream fos = new FileOutputStream(cacheFile,true);
            String message = "Le cache se cache\n";
            writeToFileOutpuStream(fos, message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeToFileOutpuStream(FileOutputStream fos, String message) throws IOException {
        fos.write(message.getBytes());
        fos.flush();    // vide buffer
        fos.close();
    }

    public void saveFile(View view) {
        try {
            FileOutputStream fos = openFileOutput(MY_FILE_TXT,MODE_APPEND);
            String message = "Le fichier fit chier\n";
            writeToFileOutpuStream(fos,message);
        } catch (IOException e) {
            e.printStackTrace();
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
