package com.example.raphael.otime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class FormTask extends AppCompatActivity {

    public static final String TITREBOOLEAN = "TITREBOOLEAN";
    public static final String DESCRIPTIONBOOLEAN = "DESCRIPTIONBOOLEAN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_task);
    }

    public void onClickValid(View view){
        EditText titleText = (EditText) findViewById(R.id.plain_text_titre);
        String plainTitre = titleText.getText().toString();
        EditText descriptionText = (EditText) findViewById(R.id.plain_text_description);
        String plainDescription = descriptionText.getText().toString();
        EditText deadlineText= (EditText) findViewById(R.id.plain_text_deadline);
        String plainDeadline = deadlineText.getText().toString();
        boolean cpt = checkText(plainTitre);
        boolean cpd = checkText(plainDescription);
        Log.i(TITREBOOLEAN,"cpt => "+cpt);
        Log.i(DESCRIPTIONBOOLEAN,"cpd => "+cpd);
    }

    public boolean checkText(String text){
        if (text.isEmpty()){
            return false;
        } else if(text.length() < 5) {
            return false;
        } else {
            return true;
        }
    }
}
