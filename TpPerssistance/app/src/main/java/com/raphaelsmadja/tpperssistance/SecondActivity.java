package com.raphaelsmadja.tpperssistance;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void showPreferences(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.MY_PREF,MODE_APPEND);
        long date = sharedPreferences.getLong(MainActivity.MY_DATE,-1);
        if(-1 == date) {
            Toast.makeText(this, "No Date Saved", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, new Date(date).toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void showCache(View view) {
        File cacheDir = getCacheDir();
        File cacheFile = new File(cacheDir,MainActivity.MY_CACHE_TXT);
        try {
            FileInputStream fis = new FileInputStream(cacheFile);
            byte[] buffer = new byte[16];
            readFromFileInputStream(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showFile(View view) {
        try {
            FileInputStream fis = openFileInput(MainActivity.MY_FILE_TXT);
            readFromFileInputStream(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void readFromFileInputStream(FileInputStream fis) throws IOException {
        byte[] buffer = new byte[16];
        StringBuilder sb = new StringBuilder();
        int nbReadBytes = -1;
        while ((nbReadBytes = fis.read(buffer))>0) {
            String  read = new String(buffer);
            sb.append(read);
        }
        Toast.makeText(this, sb.toString(), Toast.LENGTH_SHORT).show();
    }
}
