package com.raphaelsmadja.tpactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {

    public static final String TAG_SECOND_ACTIVITY="TAG_Seconde_Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i(TAG_SECOND_ACTIVITY,"onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG_SECOND_ACTIVITY,"onResume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i(TAG_SECOND_ACTIVITY,"onPause");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i(TAG_SECOND_ACTIVITY,"onStop");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(TAG_SECOND_ACTIVITY,"onDestroy");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i(TAG_SECOND_ACTIVITY,"onRestart");
    }
}
