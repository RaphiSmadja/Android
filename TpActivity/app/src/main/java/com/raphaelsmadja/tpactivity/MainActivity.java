package com.raphaelsmadja.tpactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String TAG_MAIN_ACTIVITY = "TAG_MainActivity";
    public static final String NB_TIME_CLICK_ON_BUTTON = "nbTimeClickOnButton";
    private int nbTimeClickOnButton = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG_MAIN_ACTIVITY,"onCreate");
        if(savedInstanceState != null) {
            nbTimeClickOnButton = savedInstanceState.getInt(NB_TIME_CLICK_ON_BUTTON,-1);
            Log.i(TAG_MAIN_ACTIVITY,"NB = " + nbTimeClickOnButton);
        }
        /**
         *  1ere maniere longue
         */

        Button go = (Button) findViewById(R.id.buttonGO);

        /*go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSecondActivity(v);
            }
        });*/
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i(TAG_MAIN_ACTIVITY,"onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG_MAIN_ACTIVITY,"onResume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i(TAG_MAIN_ACTIVITY,"onPause");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i(TAG_MAIN_ACTIVITY,"onStop");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(TAG_MAIN_ACTIVITY,"onDestroy");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i(TAG_MAIN_ACTIVITY,"onRestart");
    }

    /**
     *  GoToSecondActivity
     */

    public void goToSecondActivity(View view) {
        nbTimeClickOnButton++;
        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG_MAIN_ACTIVITY,"onSaveInstanceState");
        outState.putInt(NB_TIME_CLICK_ON_BUTTON, nbTimeClickOnButton);
    }
}
